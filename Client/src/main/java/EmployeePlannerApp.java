import clientNetworking.ClientFactory;
import clientNetworking.HTTPHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ModelFactory;
import view.ViewHandler;
import viewModel.ViewModelFactory;

public class EmployeePlannerApp extends Application {
    @Override
    public void start(Stage stage) {
        HTTPHandler httpHandler = new HTTPHandler();
        ClientFactory clientFactory = new ClientFactory(httpHandler);
        ModelFactory modelFactory = new ModelFactory(clientFactory);
        ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();
    }
}
