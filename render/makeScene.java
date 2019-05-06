package render;

import engine.entities.city.City;
import engine.entities.ways.EnumRoad;
import engine.entities.ways.Junction;
import engine.entities.ways.Road;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;

import java.util.Vector;

public class makeScene {

    private Scene customScene;
    private Group root = new Group();

    private Vector<City> cities;
    private Vector<Road> roads;
    private Vector<Junction> junctions;

    public makeScene(Vector<City> cities, Vector<Road> roads, Vector<Junction> junctions) {
        this.cities = cities;
        this.roads = roads;
        this.junctions = junctions;

        this.customScene = new Scene(this.root, 800, 600, Color.GRAY);
        drawCities();
        drawRoads();
        drawJunctions();
    }

    private void drawCities() {
        Group CitiesDrawing = new Group();
        for (City city : cities) {
            Circle circle = new Circle(15, Color.web("red"));
            circle.setCenterX(city.getCoordinates().getX());
            circle.setCenterY(city.getCoordinates().getY());
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 1));
            circle.setStrokeWidth(2);
            CitiesDrawing.getChildren().add(circle);
        }

        this.root.getChildren().add(CitiesDrawing);
    }

    private void drawRoads() {
        Group RoadsDrawing = new Group();
        for (Road road : roads) {
            Line line = new Line();
            line.setStartX(road.getDeparture().getCoordinates().getX());
            line.setStartY(road.getDeparture().getCoordinates().getY());
            line.setEndX(road.getArrival().getCoordinates().getX());
            line.setEndY(road.getArrival().getCoordinates().getY());

            EnumRoad roadType = road.getType();
            switch (roadType) {
                case HIGHWAY:
                    line.setStroke(Color.web("#2D2D99", 1));
                    line.setStrokeWidth(3);
                    break;
                case MAINROAD:
                    line.setStroke(Color.web("#0000FF", 1));
                    line.setStrokeWidth(2);
                    break;
                case COUNTRYROAD:
                    line.setStroke(Color.web("#6666FF", 1));
                    line.setStrokeWidth(1);
                    break;
            }

            RoadsDrawing.getChildren().add(line);
        }

        this.root.getChildren().add(RoadsDrawing);
    }

    private void drawJunctions() {
        Group JunctionsDrawing = new Group();
        for (Junction junction : junctions) {
            Circle circle = new Circle(5, Color.web("green"));
            circle.setCenterX(junction.getCoordinates().getX());
            circle.setCenterY(junction.getCoordinates().getY());
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 1));
            circle.setStrokeWidth(2);
            JunctionsDrawing.getChildren().add(circle);
        }

        this.root.getChildren().add(JunctionsDrawing);
    }

    public Scene getScene() {
        // Debug function
        root.setOnMouseClicked(event -> {
            System.out.println("X : " + event.getSceneX());
            System.out.println("Y : " + event.getSceneY());
        });

        return this.customScene;
    }

}
