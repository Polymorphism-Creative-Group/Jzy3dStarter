/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art.cctcc.tool;

import org.jzy3d.chart.factories.AWTChartFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.SurfaceBuilder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.rendering.canvas.Quality;

/**
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Jzy3D_Demo {

  public static void main(String[] args) {

    // Define a function to plot
    var mapper = new Mapper() {
      @Override
      public double f(double x, double y) {
        return 10 * Math.sin(x / 10) * Math.cos(y / 20);
      }
    };

    // Define range and precision for the function to plot
    var range = new Range(-150, 150);
    var steps = 50;

    // Create a surface drawing that function
    var surface = new SurfaceBuilder().orthonormal(new OrthonormalGrid(range, steps), mapper);
    System.out.println(surface.getBounds().getZRange());
    surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZRange()));
    surface.setFaceDisplayed(true);
    surface.setWireframeDisplayed(false);
    surface.setWireframeColor(Color.BLACK);

    // Create a chart and add the surface
    var chart = AWTChartFactory.chart(Quality.Advanced());
    chart.add(surface);
    chart.open("Jzy3d Demo", 600, 600);
  }
}
