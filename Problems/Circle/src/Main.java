class Circle {

    double radius;

    double getLength() {
        return Math.PI * this.radius * 2;
    }

    double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}