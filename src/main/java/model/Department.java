package model;

import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "departmentTitle")
    String departmentTitle;

    @Column(name = "numOfProducts")
    ind numOfProducts;

    public Department() {
        super();
    }

    public Department(int i, String departmentTitle, int numOfProducts) {
        super();
        this.id = i;
        this.departmentTitle = departmentTitle;
        this.numOfProducts = numOfProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public long getNumOfProducts() {
        return numOfProducts;
    }

    public void setNumOfProducts(int numOfProducts) {
        this.numOfProducts = numOfProducts;
    }

}