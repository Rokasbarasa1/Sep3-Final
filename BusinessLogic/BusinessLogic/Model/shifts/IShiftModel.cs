

using BusinessLogic.Model.Shared;
using Microsoft.AspNetCore.Mvc;

namespace BusinessLogic.Model.shifts
{
    interface IShiftModel
    {
        string GetShift(int id);
        string GetAllShifts(string UserId, string AccessLevel, string date);
        string PostShift(Shift shift);
        string UpdateShift(Shift shift);
        string RemoveShift(int id);
    }
}
