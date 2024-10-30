import java.util.*;

class FigureManager {
  Figure[] figures;

  FigureManager(Figure[] figures) {
    this.figures = figures;
  }

  // Count Figures by Type
  void countFigures() {
    Map<String, Integer> figureMap = new HashMap<>();

    figureMap.put("Triangle", 0);
    figureMap.put("Rectangle", 0);
    figureMap.put("Rhombus", 0);

    for (Figure figure : this.figures) {
      String type = figure.name;

      if (type.equals("Triangle")) {
        figureMap.put("Triangle", figureMap.get("Triangle") + 1);
      } else if (type.equals("Rectangle")) {
        figureMap.put("Rectangle", figureMap.get("Rectangle") + 1);
      } else {
        figureMap.put("Rhombus", figureMap.get("Rhombus") + 1);
      }
    }

    System.out.println("Figure counts:");
    System.out.println("Triangles: " + figureMap.get("Triangle"));
    System.out.println("Rectangles: " + figureMap.get("Rectangle"));
    System.out.println("Rhombuses: " + figureMap.get("Rhombus"));
  }

  // Find Largest Areas
  void findLargestAreas() {
    Map<String, Double> areaMap = new HashMap<>();

    areaMap.put("Triangle", -1.0);
    areaMap.put("Rectangle", -1.0);
    areaMap.put("Rhombus", -1.0);

    for (Figure figure : this.figures) {
      String type = figure.name;

      if (type.equals("Triangle")) {
        if (figure.getArea() > areaMap.get("Triangle")) {
          areaMap.put("Triangle", figure.getArea());
        }
      } else if (type.equals("Rectangle")) {
        if (figure.getArea() > areaMap.get("Rectangle")) {
          areaMap.put("Rectangle", figure.getArea());
        }
      } else {
        if (figure.getArea() > areaMap.get("Rhombus")) {
          areaMap.put("Rhombus", figure.getArea());
        }
      }
    }

    System.out.println("Largest areas:");
    System.out.println("Triangle: " + areaMap.get("Triangle"));
    System.out.println("Rectangle: " + areaMap.get("Rectangle"));
    System.out.println("Rhombus: " + areaMap.get("Rhombus"));

  }

  // Count Figures by Area
  void countFiguresByArea() {
    Map<Double, Integer> areaFrequencyMap = new HashMap<>();

    for (Figure figure : this.figures) {
      double area = figure.getArea();

      if (areaFrequencyMap.containsKey(area)) {
        areaFrequencyMap.put(area, areaFrequencyMap.get(area) + 1);
      } else {
        areaFrequencyMap.put(area, 1);
      }
    }

    int area20Count = 0;
    int area30Count = 0;

    if (areaFrequencyMap.containsKey(20.0)) {
      area20Count = areaFrequencyMap.get(20.0);
    }
    if (areaFrequencyMap.containsKey(30.0)) {
      area30Count = areaFrequencyMap.get(30.0);
    }

    System.out.println("Figures with area 20.0: " + area20Count);
    System.out.println("Figures with area 30.0: " + area30Count);
  }

  // Replace Figures Based on Precedence
  void replaceFigures() {
    Map<Double, Figure> areaTypeMap = new HashMap<>();

    for (Figure figure : this.figures) {
      double area = figure.getArea();
      String type = figure.name;

      if (!areaTypeMap.containsKey(area)) {
        areaTypeMap.put(area, figure);
      } else {

        if (type.equals("Rhombus")) {
          areaTypeMap.put(area, figure);
        } else if (type.equals("Rectangle") && !areaTypeMap.get(area).name.equals("Rhonbus")) {
          areaTypeMap.put(area, figure);
        } else if (type.equals("Triangle") && areaTypeMap.get(area).name.equals("Triangle")) {
          areaTypeMap.put(area, figure);
        }

      }

    }

    if (!areaTypeMap.containsKey(20.0)) {
      System.out.println("Figure with area 20.0: Key not present.");
    } else {
      System.out.println("Figure with area 20.0: " + areaTypeMap.get(20.0).name);
    }

    if (!areaTypeMap.containsKey(30.0)) {
      System.out.println("Figure with area 30.0: Key not present.");
    } else {
      System.out.println("Figure with area 30.0: " + areaTypeMap.get(30.0).name);
    }

  }

  // Calculate Average Areas by Figure Type
  void calculateAverageAreas() {
    int triCount = 0, rectCount = 0, rhomCount = 0;
    double avTriArea = 0, avRectArea = 0, avRhomArea = 0;

    Map<String, Double> totalAreaMap = new HashMap<>();
    totalAreaMap.put("Triangle", 0.0);
    totalAreaMap.put("Rectangle", 0.0);
    totalAreaMap.put("Rhombus", 0.0);

    for (Figure figure : this.figures) {
      totalAreaMap.put(figure.name, totalAreaMap.get(figure.name) + figure.getArea());
      if (figure.name.equals("Triangle")) {
        triCount++;
      } else if (figure.name.equals("Rectangle")) {
        rectCount++;
      } else {
        rhomCount++;
      }
    }

    System.out.println("Average areas:");

    if (triCount != 0) {
      avTriArea = totalAreaMap.get("Triangle") / triCount;
      System.out.println("Triangle: " + avTriArea);
    }
    if (rectCount != 0) {
      avRectArea = totalAreaMap.get("Rectangle") / rectCount;
      System.out.println("Rectangle: " + avRectArea);
    }
    if (rhomCount != 0) {
      avRhomArea = totalAreaMap.get("Rhombus") / rhomCount;
      System.out.println("Rhombus: " + avRhomArea);
    }

  }
}
