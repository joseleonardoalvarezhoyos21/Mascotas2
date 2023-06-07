import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Mascotas {
    private String id;
    private String nombre;
    private String tipo;
    private int edad;

    public Mascotas() {
    }

    public Mascotas(String id, String nombre, String tipo, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
    }

    public void mostrarInformacion() {
        JOptionPane.showMessageDialog(null, "------------Información de la mascota----------\n\n" 
                +"ID: " + id + "\n" 
                +"Nombre: " + nombre + "\n" 
                +"Tipo: " + tipo + "\n" 
                +"Edad: " + edad + " años\n" );
        emitirSonido();
        alimentar();
    }

    public void emitirSonido() {
        if (tipo.equalsIgnoreCase("perro")) {
            JOptionPane.showMessageDialog(null, "¡Guau guau!");
        } else if (tipo.equalsIgnoreCase("gato")) {
            JOptionPane.showMessageDialog(null, "¡Miau miau!");
        } else {
            JOptionPane.showMessageDialog(null, "La mascota no emite sonidos reconocibles.");
        }
    }

    public void alimentar() {
        if (tipo.equalsIgnoreCase("perro")) {
            JOptionPane.showMessageDialog(null, "¡Come carne y pollo!");
        } else if (tipo.equalsIgnoreCase("gato")) {
            JOptionPane.showMessageDialog(null, "¡Come pescado!");
        } else {
            JOptionPane.showMessageDialog(null, "La mascota no tiene hambre.");
        }
    }

    public void ingresarDatos() {
        id = JOptionPane.showInputDialog("Ingresa el ID de la mascota:");
        nombre = JOptionPane.showInputDialog("Ingresa el nombre de la mascota: ");
        tipo = JOptionPane.showInputDialog("Ingresa el tipo de mascota: ");
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad de la mascota: "));
    }

    public static void main(String[] args) {
        ArrayList<Mascotas> listaMascotas = new ArrayList<>();
        HashMap<String, Mascotas> mapaMascotas = new HashMap<>();

        int opcion;
        String menu = "";
        do {
            menu = "MENÚ\n";
            menu += "1. Crear una mascota\n";
            menu += "2. Ver información de una mascota\n";
            menu += "3. Ver lista de mascotas\n";
            menu += "4. Modificar una mascota\n";
            menu += "5. Salir\n";
            menu += "Ingresa una opción:\n ";

            opcion =Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    Mascotas mascota = new Mascotas();
                    mascota.ingresarDatos();
                    listaMascotas.add(mascota);
                    mapaMascotas.put(mascota.getPetId(), mascota);
                    break;
                case 2:
                    String idMascota = JOptionPane.showInputDialog("Ingresa el ID de la mascota a ver: ");
                    if (mapaMascotas.containsKey(idMascota)) {
                        Mascotas mascotaAVisualizar = mapaMascotas.get(idMascota);
                        mascotaAVisualizar.mostrarInformacion();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con el ID ingresado.");
                    }
                    break;
                case 3:
                    String informacionMascotas = "Lista de mascotas:\n";
                    for (Mascotas mascotaEnLista : listaMascotas) {
                        informacionMascotas += "ID: " + mascotaEnLista.getPetId() + ", Nombre: " + mascotaEnLista.getPetName() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, informacionMascotas);
                    break;
                case 4:
                    idMascota = JOptionPane.showInputDialog("Ingresa el ID de la mascota a modificar: ");
                    if (mapaMascotas.containsKey(idMascota)) {
                        Mascotas mascotaAModificar = mapaMascotas.get(idMascota);
                        mascotaAModificar.ingresarDatos();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna mascota con el ID ingresado.");
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, intenta nuevamente.");
            }
        } while (opcion != 5);
    }

    public String getPetId() {
        return id;
    }

    public void setPetId(String petId) {
        this.id = petId;
    }

    public String getPetName() {
        return nombre;
    }

    public void setPetName(String petName) {
        this.tipo = petName;
    }

    public String getPetType() {
        return tipo;
    }

    public void setPetType(String petType) {
        this.tipo = petType;
    }

    public int getPetAge() {
        return edad;
    }

    public void setPetAge(int petAge) {
        this.edad = petAge;
    }
}