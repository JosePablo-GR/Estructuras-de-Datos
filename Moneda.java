import java.util.Random;

public class Moneda {

	public static int racha(int[] registro) {

	    int veces = 0;

	    for (int i = 0; i < registro.length - 1; i++) {

	        if (registro[i] == registro[i + 1]) {

	            veces++;

	        }

	    }

	    return veces;

	}

	public static double[] porcentaje (int total, int aguila, int sol) {

		double[] proporcion = new double[2];

		proporcion[0] = (aguila * 100) / total;
		proporcion[1] = (sol * 100) / total;
		//proporcion[1] = 100 - proporcion[0];

		return proporcion;

	}

	public static void imprimirArreglo(int[] arreglo) {

        System.out.print("[");

        for (int i = 0; i < arreglo.length; i++) {

            System.out.print(arreglo[i]);

            if (i < arreglo.length - 1) {

                System.out.print(", ");

            }

        }

        System.out.println("]");

    }
	
	public static void main (String[] args) {

		Random rd = new Random();

		try {

			char c = args[0].charAt(0);
			int n = Character.getNumericValue(c);

			//System.out.println("Me repito " + n + " veces.");

			int aguila = 0;
			int sol = 0;
			int[] registro = new int[n];

			for (int i = 0; i < n; i++) {

				boolean moneda = rd.nextBoolean();

				aguila += (moneda ? 1 : 0);
				sol += (moneda ? 0 : 1);

				registro[i] = moneda ? 1 : 0;

			}

			imprimirArreglo(registro);
			System.out.println("Racha: " + racha(registro));

			System.out.println("\"Águila\" salió " + aguila + " veces.");
			System.out.println("\"Sol\" salió " + sol + " veces.");

			double proporcion[] = porcentaje(n,aguila,sol);

			System.out.println("El porcentaje de \"Águila\" fue: " + proporcion[0] + "%.");
			System.out.println("El porcentaje de \"Sol\" fue: " + proporcion[1] + "%.");

		} catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {

			System.out.println("Error: Argumentos inválidos\n" + e.getMessage());

		}

	}

}
