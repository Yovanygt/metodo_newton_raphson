/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.newtonrapshon;

/**
 *
 * @author grans
 */
import java.util.Scanner;

public class NewtonRapshon{

    static final int MAX_ITER = 100;
    static final double TOL = 1e-6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vamos a resolver el siguiente sistema:");
        System.out.println("f1(x, y, z) = x^2 + y^2 + z^2 - 9");
        System.out.println("f2(x, y, z) = x + y - z - 1");
        System.out.println("f3(x, y, z) = x - y + z - 1\n");

        // Paso 1: Ingreso de valores iniciales
        System.out.println("Por favor, ingrese los valores iniciales:");
        System.out.print("x0: ");
        double x0 = sc.nextDouble();
        System.out.print("y0: ");
        double y0 = sc.nextDouble();
        System.out.print("z0: ");
        double z0 = sc.nextDouble();

        double[] x = {x0, y0, z0};

        for (int iter = 0; iter < MAX_ITER; iter++) {
            System.out.println("\n--- Iteracion " + (iter + 1) + " ---");

            // Paso 2: Evaluar funciones
            double[] F = evalFunciones(x);
            System.out.printf("Evaluamos el vector F(x): [%.6f, %.6f, %.6f]%n", F[0], F[1], F[2]);

            // Paso 3: Evaluar la Jacobiana
            double[][] J = evalJacobiana(x);
            System.out.println("Evaluamos la matriz Jacobiana J(x):");
            imprimirMatriz(J);

            // Paso 4: Resolver J * delta = F
            System.out.println("Resolvemos el sistema J·Δ = F para encontrar la corrección Δ:");
            double[] delta = resolverSistema(J, F);
            System.out.printf(" = [%.6f, %.6f, %.6f]%n", delta[0], delta[1], delta[2]);

            // Paso 5: Actualizar x
            for (int i = 0; i < 3; i++) {
                x[i] -= delta[i];
            }

            System.out.printf("Nuevos valores: x = %.6f, y = %.6f, z = %.6f%n", x[0], x[1], x[2]);

            if (norma(delta) < TOL) {
                System.out.println("\n✅ ¡Convergencia alcanzada!");
                System.out.printf("Solución aproximada: x = %.6f, y = %.6f, z = %.6f%n", x[0], x[1], x[2]);
                break;
            }
        }

        System.out.println("Ejemplo terminado ");
    }

    public static double[] evalFunciones(double[] x) {
        double[] F = new double[3];
        F[0] = x[0]*x[0] + x[1]*x[1] + x[2]*x[2] - 9;
        F[1] = x[0] + x[1] - x[2] - 1;
        F[2] = x[0] - x[1] + x[2] - 1;
        return F;
    }

    public static double[][] evalJacobiana(double[] x) {
        double[][] J = new double[3][3];
        J[0][0] = 2 * x[0];
        J[0][1] = 2 * x[1];
        J[0][2] = 2 * x[2];
        J[1][0] = 1; J[1][1] = 1; J[1][2] = -1;
        J[2][0] = 1; J[2][1] = -1; J[2][2] = 1;
        return J;
    }

    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double valor : fila) {
                System.out.printf("%10.6f ", valor);
            }
            System.out.println();
        }
    }

    public static double[] resolverSistema(double[][] A, double[] b) {
        int n = 3;
        double[][] M = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, M[i], 0, n);
            M[i][n] = b[i];
        }

        for (int i = 0; i < n; i++) {
            int maxRow = i;
            for (int k = i+1; k < n; k++) {
                if (Math.abs(M[k][i]) > Math.abs(M[maxRow][i])) {
                    maxRow = k;
                }
            }
            double[] temp = M[i];
            M[i] = M[maxRow];
            M[maxRow] = temp;

            for (int k = i+1; k < n; k++) {
                double factor = M[k][i] / M[i][i];
                for (int j = i; j <= n; j++) {
                    M[k][j] -= factor * M[i][j];
                }
            }
        }

        double[] x = new double[n];
        for (int i = n-1; i >= 0; i--) {
            x[i] = M[i][n];
            for (int j = i+1; j < n; j++) {
                x[i] -= M[i][j] * x[j];
            }
            x[i] /= M[i][i];
        }

        return x;
    }

    public static double norma(double[] v) {
        double sum = 0;
        for (double val : v) {
            sum += val * val;
        }
        return Math.sqrt(sum);
    }
}
