// Figure Class
class Figure {
  String name;
  double dim1, dim2;

  // Constructor
  Figure(String name, double dim1, double dim2) {
    this.name = name;
    this.dim1 = dim1;
    this.dim2 = dim2;
  }

  // Method to calculate area
  double getArea() {
    if (this.name.equals("Rectangle")) {
      return this.dim1 * this.dim2;
    } else {
      return 0.5 * this.dim1 * this.dim2;
    }
  }
}
