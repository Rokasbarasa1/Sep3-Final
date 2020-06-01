using BusinessLogic.Model.Shared;
using BusinessLogic.Model.shifts;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ShiftController : ControllerBase
    {
        private IShiftModel shiftModel;

        public ShiftController()
        {
            shiftModel = new ShiftModel();
        }

        // GET: api/Shifts
        [HttpGet]
        public async Task<ActionResult<String>> GetShifts([FromQuery(Name = "username")] string username, [FromQuery(Name = "accessLevel")] string accessLevel, [FromQuery(Name = "date")] string date)
        {
            Console.WriteLine("GetShifts");
            return shiftModel.GetAllShifts(username, accessLevel, date);
        }


        // GET: api/Shifts/5
        [HttpGet("{id}")]
        public async Task<ActionResult<String>> GetShift(int id)
        {
            Console.WriteLine("GetShift");
            return shiftModel.GetShift(id);
        }


        // POST: api/Shifts
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<String>> PostShift(Shift shift)
        {
            Console.WriteLine("PostShift");
            return shiftModel.PostShift(shift);
        }

        // DELETE: api/Shift/RemoveShift/5(shiftId)
        [HttpDelete("{id}")]
        public async Task<ActionResult<String>> RemoveShift(int id)
        {
            Console.WriteLine("RemoveShift");
            return shiftModel.RemoveShift(id);
        }
        /* WHOS IDEA WAS IT TO USE POST FOR UPDATING
        [HttpPost]
        public async Task<ActionResult<String>> UpdateShift(Shift shift)
        {
            Console.WriteLine("UpdateShift");
            return shiftModel.UpdateShift(shift);
        }
        */
    }
}
