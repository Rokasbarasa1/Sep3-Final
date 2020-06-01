
using System;

namespace BusinessLogic.Model.Shared
{
    public class User
    {
        public int id { get; set; }
        public int managerID { get; set; }
        public string username { get; set; }
        public string password { get; set; }
        public string fname { get; set; }
        public string lname { get; set; }
        public string email { get; set; }
        public string status { get; set; }
        public LocalDate employmentDate { get; set; }
        public string accessLevel { get; set; }
    }
}