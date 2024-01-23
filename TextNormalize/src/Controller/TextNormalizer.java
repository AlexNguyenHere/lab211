package Controller;
import controller.TextController;
import model.TextModel;
import view.TextView;

public class TextNormalizer {
    public static void main(String[] args) {
        TextModel model = new TextModel();
        TextView view = new TextView();
        TextController controller = new TextController(model, view);
        controller.run();
    }
}