using BusinessLogic.Model.Shared;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Model.user
{
    interface IUserModel
    {
        string GetUsers(object id);
        string PostUser(User user);
        string GetUser(int id);
        string GetUsersIdName(int managerId);
        string GetUsersByManager(int managerId);
        string RemoveUser(int id);
    }
}
