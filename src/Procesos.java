import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Procesos {
    private HashMap<String, ArrayList<String>> paisesYCiudades;

    public Procesos() {
        paisesYCiudades = new HashMap<>();
    }

    public void iniciar() {
        String opciones = "GESTION ESTUDIANTES\n";
        opciones += "1. Añadir país\n";
        opciones += "2. Añadir ciudades\n";
        opciones += "3. Buscar ciudades por país\n";
        opciones += "4. Buscar ciudad\n";
        opciones += "5. Salir\n";
        opciones += "Ingrese una opción:\n";

        int opcionMenu = 0;
        do {
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(opciones));

            ejecutarMenu(opcionMenu);

        } while (opcionMenu != 5);
    }

    public void ejecutarMenu(int opcionMenu) {
        switch (opcionMenu) {
            case 1:
                añadirPais();
                break;
            case 2:
                añadirCiudad();
                break;
            case 3:
                buscarCiudadesPorPais();
                break;
            case 4:
                buscarCiudad();
                break;
            case 5:
                System.out.println("¡Adiós!");
                break;
            default:
                System.out.println("Por favor, ingrese una opción válida");
                break;
        }
    }

    public void añadirPais() {
        String pais = JOptionPane.showInputDialog("Ingrese el nombre del país");
        if (!paisesYCiudades.containsKey(pais)) {
            paisesYCiudades.put(pais, new ArrayList<>());
            System.out.println("País añadido correctamente.");
        } else {
            System.out.println("El país ya está añadido.");
        }
    }

    public void añadirCiudad() {
        String pais = JOptionPane.showInputDialog("Ingrese el país donde desea añadir la ciudad");
        if (paisesYCiudades.containsKey(pais)) {
            String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad");
            ArrayList<String> ciudades = paisesYCiudades.get(pais);
            if (!ciudades.contains(ciudad)) {
                ciudades.add(ciudad);
                System.out.println("Ciudad añadida correctamente.");
            } else {
                System.out.println("La ciudad ingresada ya ha sido agregada en este país.");
            }
        } else {
            System.out.println("El país no está añadido.");
        }
    }

    public void buscarCiudadesPorPais() {
        String pais = JOptionPane.showInputDialog("Ingrese el país para buscar las ciudades");
        if (paisesYCiudades.containsKey(pais)) {
            ArrayList<String> ciudades = paisesYCiudades.get(pais);
            System.out.println("Ciudades de " + pais + ":");
            for (String ciudad : ciudades) {
                System.out.println(ciudad);
            }
        } else {
            System.out.println("El país no está añadido.");
        }
    }

    public void buscarCiudad() {
        String ciudad = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad que desea buscar");
        boolean ciudadEncontrada = false;
        for (String pais : paisesYCiudades.keySet()) {
            ArrayList<String> ciudades = paisesYCiudades.get(pais);
            if (ciudades.contains(ciudad)) {
                System.out.println("La ciudad " + ciudad + " existe en " + pais);
                ciudadEncontrada = true;
                break;
            }
        }
        if (!ciudadEncontrada) {
            System.out.println("La ciudad " + ciudad + " no existe en ningún país añadido.");
        }
    }
}
