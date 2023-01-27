package com.cs.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "smoothie")
public class Smoothie {

  private long id;
  private String name;
  private String vitaminA;
  private String vitaminB;
  private String vitaminC;
  private String calcium;
  private String iron;
  private String protein;
  private String carbohydrates;
  private String cholesterol;
  private String fat;

  public Smoothie() {}

  public Smoothie(
      long id,
      String name,
      String vitaminA,
      String vitaminB,
      String vitaminC,
      String calcium,
      String iron,
      String protein,
      String carbohydrates,
      String cholesterol,
      String fat) {
    this.id = id;
    this.name = name;
    this.vitaminA = vitaminA;
    this.vitaminB = vitaminB;
    this.vitaminC = vitaminC;
    this.calcium = calcium;
    this.iron = iron;
    this.protein = protein;
    this.carbohydrates = carbohydrates;
    this.cholesterol = cholesterol;
    this.fat = fat;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "name", nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "vitamin_a", nullable = true)
  public String getVitaminA() {
    return vitaminA;
  }

  public void setVitaminA(String vitaminA) {
    this.vitaminA = vitaminA;
  }

  @Column(name = "vitamin_b", nullable = true)
  public String getVitaminB() {
    return vitaminB;
  }

  public void setVitaminB(String vitaminB) {
    this.vitaminB = vitaminB;
  }

  @Column(name = "vitamin_c", nullable = true)
  public String getVitaminC() {
    return vitaminC;
  }

  public void setVitaminC(String vitaminC) {
    this.vitaminC = vitaminC;
  }

  @Column(name = "calcium", nullable = true)
  public String getCalcium() {
    return calcium;
  }

  public void setCalcium(String calcium) {
    this.calcium = calcium;
  }

  @Column(name = "iron", nullable = true)
  public String getIron() {
    return iron;
  }

  public void setIron(String iron) {
    this.iron = iron;
  }

  @Column(name = "protein", nullable = true)
  public String getProtein() {
    return protein;
  }

  public void setProtein(String protein) {
    this.protein = protein;
  }

  @Column(name = "carbohydrates", nullable = true)
  public String getCarbohydrates() {
    return carbohydrates;
  }

  public void setCarbohydrates(String carbohydrates) {
    this.carbohydrates = carbohydrates;
  }

  @Column(name = "cholesterol", nullable = true)
  public String getCholesterol() {
    return cholesterol;
  }

  public void setCholesterol(String cholesterol) {
    this.cholesterol = cholesterol;
  }

  @Column(name = "fat", nullable = true)
  public String getFat() {
    return fat;
  }

  public void setFat(String fat) {
    this.fat = fat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Smoothie smoothie = (Smoothie) o;
    return id == smoothie.id
        && name.equals(smoothie.name)
        && Objects.equals(vitaminA, smoothie.vitaminA)
        && Objects.equals(vitaminB, smoothie.vitaminB)
        && Objects.equals(vitaminC, smoothie.vitaminC)
        && Objects.equals(calcium, smoothie.calcium)
        && Objects.equals(iron, smoothie.iron)
        && Objects.equals(protein, smoothie.protein)
        && Objects.equals(carbohydrates, smoothie.carbohydrates)
        && Objects.equals(cholesterol, smoothie.cholesterol)
        && Objects.equals(fat, smoothie.fat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        name,
        vitaminA,
        vitaminB,
        vitaminC,
        calcium,
        iron,
        protein,
        carbohydrates,
        cholesterol,
        fat);
  }

  @Override
  public String toString() {
    return "Smoothie{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", vitaminA='"
        + vitaminA
        + '\''
        + ", vitaminB='"
        + vitaminB
        + '\''
        + ", vitaminC='"
        + vitaminC
        + '\''
        + ", calcium='"
        + calcium
        + '\''
        + ", iron='"
        + iron
        + '\''
        + ", protein='"
        + protein
        + '\''
        + ", carbohydrates='"
        + carbohydrates
        + '\''
        + ", cholesterol='"
        + cholesterol
        + '\''
        + ", fat='"
        + fat
        + '\''
        + '}';
  }
}
