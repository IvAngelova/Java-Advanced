package T8Generics.lab.JarOfT_01;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();
        jar.add("Pesho");
        jar.add("Gosho");
        jar.add("Acho");
        System.out.println(jar.remove());
        System.out.println(jar.size());
    }
}
