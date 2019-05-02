package render;

import engine.entities.city.City;
import engine.entities.ways.Junction;
import engine.entities.ways.Road;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;

import java.util.Vector;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class makeScene {

    private Scene customScene;
    private Group root = new Group();
    private Group circles = new Group();
    private Group circles1 = new Group();
    private Group lines = new Group();

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

    public void drawCities() {
        for (City city : cities) {
            Circle circle = new Circle(15, Color.web("red"));
            circle.setCenterX(city.getCoordinates().getX());
            circle.setCenterY(city.getCoordinates().getY());
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 1));
            circle.setStrokeWidth(2);
            this.circles.getChildren().add(circle);
        }

        this.root.getChildren().add(this.circles);
    }

    public void drawRoads() {
        for (Road road : roads) {
            Line line = new Line();
            line.setStroke(Color.web("blue", 1));
            line.setStartX(road.getDeparture().getCoordinates().getX());
            line.setStartY(road.getDeparture().getCoordinates().getY());
            line.setEndX(road.getArrival().getCoordinates().getX());
            line.setEndY(road.getArrival().getCoordinates().getY());
            this.lines.getChildren().add(line);
        }

        this.root.getChildren().add(this.lines);
    }

    public void drawJunctions() {
        for (Junction junction : junctions) {
            Circle circle = new Circle(5, Color.web("green"));
            circle.setCenterX(junction.getCoordinates().getX());
            circle.setCenterY(junction.getCoordinates().getY());
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 1));
            circle.setStrokeWidth(2);
            this.circles1.getChildren().add(circle);
        }

        this.root.getChildren().add(this.circles1);
    }

    public Scene getScene() {
        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("X : " + event.getSceneX());
                System.out.println("Y : " + event.getSceneY());
            }
        });
        return this.customScene;
    }

}
