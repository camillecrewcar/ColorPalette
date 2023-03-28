package com.example.projekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ColorMixerController implements Initializable {
    @FXML
    public VBox listOfColors;
    @FXML
    public Button menuButton;
    @FXML
    public Slider blueSlider;
    @FXML
    public Label redLabel;
    @FXML
    public Label blueLabel;
    @FXML
    public Slider greenSlider;
    @FXML
    public Label greenLabel;
    @FXML
    public Slider redSlider;
    @FXML
    public Rectangle outputColor;
    @FXML
    public Button findColorButton;
    @FXML
    public Rectangle foundColor;
    @FXML
    public Label colorName;
    @FXML
    public Label createdFrom;
    @FXML
    public Label mixedColorOneLabel;
    @FXML
    public Label mixedColorTwoLabel;
    @FXML
    public Label proportionOneLabel;
    @FXML
    public Label proportionTwoLabel;
    @FXML
    public Label inProportionLabel;
    private int currentRed;
    private int currentGreen;
    private int currentBlue;
    private int bestProportion;
    private ColorRGB bestFirstColor;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSliders();

        List<ColorRGB> kolory = UserColors.getInstance().userColors;


        if (kolory != null){
            for (ColorRGB colorRGB : kolory) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("colorListItem.fxml"));
                try {
                    HBox hBox = fxmlLoader.load();
                    ColorListItemController cic = fxmlLoader.getController();
                    cic.setData(colorRGB);
                    listOfColors.getChildren().add(hBox);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    void setSliders(){
        currentRed = 0;
        currentGreen = 0;
        currentBlue = 0;
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            currentRed = newValue.intValue();
            redLabel.setText(String.valueOf(newValue.intValue()));
            outputColor.setFill(Color.rgb(currentRed,currentGreen,currentBlue));
        });


        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            currentGreen = newValue.intValue();
            greenLabel.setText(String.valueOf(newValue.intValue()));
            outputColor.setFill(Color.rgb(currentRed,currentGreen,currentBlue));
        });
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            currentBlue = newValue.intValue();
            blueLabel.setText(String.valueOf(currentBlue));
            outputColor.setFill(Color.rgb(currentRed,currentGreen,currentBlue));
        });
    }
    public void changeView(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) menuButton.getScene().getWindow();
        if(actionEvent.getSource() == menuButton) {

            root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    public ColorRGB mostFittingColour(ArrayList<ColorRGB> searchedList){
        int record = 800;
        ColorRGB bestColor = new ColorRGB();
        ColorRGB compared = new ColorRGB("compared",currentRed,currentGreen,currentBlue);
        for (ColorRGB color:
                searchedList) {
            int currentPoints = ColorRGB.comparePoints(compared,color);
            if (currentPoints < record){
                record = currentPoints;
                bestColor = color;
            }
        }
        return bestColor;
    }
    public ColorRGB mostFittingColour(ArrayList<ColorRGB> searchedList, ColorRGB colorRGB){
        int record = 800;
        ColorRGB bestColor = new ColorRGB();

        for (ColorRGB color:
                searchedList) {
            int currentPoints = ColorRGB.comparePoints(colorRGB,color);
            if (currentPoints < record){
                record = currentPoints;
                bestColor = color;
            }
        }
        return bestColor;
    }
    public ColorRGB bestToMix(ColorRGB wanted, ColorRGB best, ArrayList<ColorRGB> list){
        int rNeeded = wanted.getRed() + wanted.getRed() - best.getRed();
        if(rNeeded > 255){
            rNeeded = 255;
        } else if (rNeeded < 0) {
            rNeeded = 0;
        }
        int bNeeded = wanted.getBlue() + wanted.getBlue() - best.getBlue();
        if(bNeeded > 255){
            bNeeded = 255;
        } else if (bNeeded < 0) {
            bNeeded = 0;
        }
        int gNeeded = wanted.getGreen() + wanted.getGreen() - best.getGreen();
        if(gNeeded > 255){
            gNeeded = 255;
        } else if (gNeeded < 0) {
            gNeeded = 0;
        }

        return mostFittingColour(list,new ColorRGB("toMix", rNeeded,gNeeded,bNeeded));

    }

    public void findColor(ActionEvent actionEvent) {
        ColorsRepo colorsRepo = new ColorsRepo();
        UserColors.getInstance().userColors.clear();
        for (Colors color:
                colorsRepo.findColors(UserColors.getInstance().currentUser.getId())) {
            UserColors.getInstance().userColors.add(new ColorRGB(color.getName(),color.getRed(),color.getGreen(),color.getBlue()));
        }
        ArrayList<ColorRGB> temp = UserColors.getInstance().userColors;
        bestFirstColor = mostFittingColour(temp);
        temp.remove(mostFittingColour(temp));


        ColorRGB compared = new ColorRGB("compared",currentRed,currentGreen,currentBlue);
        colorName.setVisible(true);
        createdFrom.setVisible(false);
        mixedColorOneLabel.setVisible(false);
        mixedColorTwoLabel.setVisible(false);
        inProportionLabel.setVisible(false);
        proportionOneLabel.setVisible(false);
        proportionTwoLabel.setVisible(false);
        if (ColorRGB.comparePoints(compared,bestFirstColor) > 30){
            ColorRGB idealOpozition = bestToMix(compared,bestFirstColor,temp);


            ColorRGB mieszany = mixColors(bestFirstColor,idealOpozition);
            if (ColorRGB.comparePoints(compared,mieszany) > 60){
                System.out.println(ColorRGB.comparePoints(compared,mieszany));
                colorName.setText("ciezko otrzymac");
            } else {
                foundColor.setFill(Color.rgb(mieszany.getRed(),mieszany.getGreen(),mieszany.getBlue()));
                createdFrom.setVisible(true);
                mixedColorOneLabel.setVisible(true);
                mixedColorOneLabel.setText(bestFirstColor.getName());
                mixedColorTwoLabel.setVisible(true);
                mixedColorTwoLabel.setText(idealOpozition.getName());
                inProportionLabel.setVisible(true);
                proportionOneLabel.setVisible(true);
                proportionOneLabel.setText(bestProportion + "%");
                proportionTwoLabel.setVisible(true);
                proportionTwoLabel.setText(100 - bestProportion + "%");
                colorName.setText("Mieszany");
            }
        }else {
            foundColor.setFill(Color.rgb(bestFirstColor.getRed(), bestFirstColor.getGreen(), bestFirstColor.getBlue()));

            colorName.setText(bestFirstColor.getName());

        }

    }
    public ColorRGB mixColors(ColorRGB wanted, ColorRGB toMixOne){

        int rekordProp = ColorRGB.comparePoints(toMixOne,wanted);
        int bestProportion = 50;
        ColorRGB rekordColor = toMixOne;
        ArrayList<ColorRGB> temp = UserColors.getInstance().userColors;

        ColorRGB oposition = bestToMix(wanted,toMixOne, temp);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {

            double propOne = random.nextDouble(0,1);
            double propTwo = 1 - propOne;
            int red = (int) (toMixOne.getRed() * propOne + oposition.getRed() * propTwo);
            int green = (int) (toMixOne.getGreen() * propOne + oposition.getGreen() * propTwo);
            int blue = (int)(toMixOne.getBlue() * propOne + oposition.getBlue() * propTwo);

            ColorRGB mixedColor = new ColorRGB("mixed",red,green,blue);
            if(ColorRGB.comparePoints(wanted,mixedColor) < rekordProp){

                rekordProp =ColorRGB.comparePoints(wanted,mixedColor);
                rekordColor = mixedColor;
                bestProportion = (int) (propOne*100);

            }

        }
        this.bestProportion = bestProportion;
        System.out.println(rekordColor.getRed() + " " + rekordColor.getGreen() + " " + rekordColor.getBlue());
        return rekordColor;
    }
}
