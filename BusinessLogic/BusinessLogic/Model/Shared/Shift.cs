using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.Model.Shared;

namespace BusinessLogic.Model.Shared
{
    public class Shift
    {
        public int id { get; set; }
        public int user_id { get; set; }
        public string description { get; set; }
        public int manager_id { get; set; }
        public LocalDate date { get; set; }
        
    }
}
