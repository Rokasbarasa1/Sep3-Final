using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Hosting;
using System;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace BusinessLogic
{
    public class Program
    {
        public static void Main(string[] args)
        {
            try
            {
                //Only for getting your ip. So you dont have to change it every time.
                string localIP;
                using (Socket socket = new Socket(AddressFamily.InterNetwork, SocketType.Dgram, 0))
                {
                    socket.Connect("8.8.8.8", 65530);
                    IPEndPoint endPoint = socket.LocalEndPoint as IPEndPoint;
                    localIP = endPoint.Address.ToString();
                }

                IPEndPoint serverAddress = new IPEndPoint(IPAddress.Parse(localIP), 4343);
                Socket BusinessSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                BusinessSocket.Connect(serverAddress);
                BusinessSocketHandler socketHandler = BusinessSocketHandler.getInstance();
                socketHandler.setSocket(BusinessSocket);

                socketHandler.SendToDatabaseStringOnly("Check");
                string response = socketHandler.GetResponse();
                if (response.Equals("Check"))
                {
                    Console.WriteLine("Connection to Database established");
                }
                else
                {
                    Console.WriteLine("Connection to database failed");
                }
                
            }
            catch (Exception e)// Breaking of solid principles
            {
                Console.WriteLine(e.Message);
            }
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    webBuilder.UseStartup<Startup>();
                });
    }
}