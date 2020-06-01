using BusinessLogic.Model.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Model.login
{
    interface ILoginModel
    {
        string ValidateLogin(User user);
    }
}
