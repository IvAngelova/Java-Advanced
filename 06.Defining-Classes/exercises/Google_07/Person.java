package T6DefiningClasses.exercises.Google_07;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemonList;
    private List<Parent> parents;
    private List<Child> children;

    public Person() {
        this.pokemonList = new ArrayList<>();
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Parent> getParents() {
        return parents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:\n");
        if(company != null){
            sb.append(company.toString()).append("\n");
        }
        sb.append("Car:\n");
        if(car != null){
            sb.append(car.toString()).append("\n");
        }
        sb.append("Pokemon:\n");
        for (Pokemon pokemon : pokemonList) {
            sb.append(pokemon.toString()).append("\n");
        }
        sb.append("Parents:\n");
        for (Parent parent : parents) {
            sb.append(parent.toString()).append("\n");
        }
        sb.append("Children:\n");
        for (Child child : children) {
            sb.append(child.toString()).append("\n");
        }
        return sb.toString();
    }
}
