using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.Model;
using BusinessLogic.Model.Shared;
using BusinessLogic.Model.user;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace BusinessLogic.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly IUserModel userModel;

        public UserController()
        {
            userModel = new UserModel();
        }

        // POST: api/User
        [HttpPost]
        public async Task<ActionResult<string>> PostUser(User user)
        {
            Console.WriteLine("PostUser");
            return userModel.PostUser(user);
        }

        // GET: api/User/id
        [HttpGet("{id}")]
        public async Task<ActionResult<string>> GetUser(int id)
        {
            Console.WriteLine("GetUser");
            return  userModel.GetUser(id);
        }

        // GET: api/Employee
        [HttpGet("id-name")]
        public async Task<ActionResult<string>> GetUsersIdName([FromQuery(Name = "managerId")] int managerId)
        {
            Console.WriteLine("GetUsersIdName");
            return userModel.GetUsersIdName(managerId);
        }

        [HttpGet]
        public async Task<ActionResult<string>> GetUsers([FromQuery(Name = "managerId")] int managerId)
        {
            Console.WriteLine("GetUsers");
            return userModel.GetUsersByManager(managerId);
        }

        // DELEtE: api/Employee
        [HttpDelete("{id}")]
        public async Task<ActionResult<String>> RemoveUser(int id)
        {
            Console.WriteLine("RemoveUser");
            return userModel.RemoveUser(id);
        }
    }
}
