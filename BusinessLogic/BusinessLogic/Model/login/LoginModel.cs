using BusinessLogic.Model.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Model.login
{
    public class LoginModel : ILoginModel
    {
        private BusinessSocketHandler socketHandler;

        public LoginModel()
        {
            socketHandler = BusinessSocketHandler.getInstance();
        }


        public string ValidateLogin(User user)
        {
            socketHandler.SendToDatabase("Login", user);
            string result = socketHandler.GetResponse();
            string[] resultSlpit = result.Split(";");
            if (resultSlpit[0].Equals("OK"))
            {
                return "Login successful;" + resultSlpit[1];
            }
            else
            {
                return "Wrong username or password";
            }
        }
    }
}
