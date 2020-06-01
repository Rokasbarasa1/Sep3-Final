using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Model;
using BusinessLogic.Model.Shared;
using BusinessLogic.Model.login;

namespace BusinessLogic.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LoginController : ControllerBase
    {
        private ILoginModel loginModel;

        public LoginController()
        {
            loginModel = new LoginModel();
        }


        // POST: api/Login
        [HttpPost]
        public async Task<ActionResult<string>> ValidateUser(User user)
        {
            Console.WriteLine("ValidatUser");
            return loginModel.ValidateLogin(user);
        }
    }
}