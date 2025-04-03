package dev.tau.countrydata.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "Code", length = 3)
    private String code;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Continent", nullable = false)
    private String continent;

    @Column(name = "Region", nullable = false)
    private String region;

    @Column(name = "SurfaceArea")
    private Double surfaceArea;

    @Column(name = "Population")
    private Integer population;

    @Column(name = "LifeExpectancy")
    private Double lifeExpectancy;

    @Column(name = "GNP")
    private Double gnp;

    @Column(name = "LocalName")
    private String localName;

    @Column(name = "GovernmentForm")
    private String governmentForm;

    // Getterit ja setterit
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContinent() { return continent; }
    public void setContinent(String continent) { this.continent = continent; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public Double getSurfaceArea() { return surfaceArea; }
    public void setSurfaceArea(Double surfaceArea) { this.surfaceArea = surfaceArea; }

    public Integer getPopulation() { return population; }
    public void setPopulation(Integer population) { this.population = population; }

    public Double getLifeExpectancy() { return lifeExpectancy; }
    public void setLifeExpectancy(Double lifeExpectancy) { this.lifeExpectancy = lifeExpectancy; }

    public Double getGnp() { return gnp; }
    public void setGnp(Double gnp) { this.gnp = gnp; }

    public String getLocalName() { return localName; }
    public void setLocalName(String localName) { this.localName = localName; }

    public String getGovernmentForm() { return governmentForm; }
    public void setGovernmentForm(String governmentForm) { this.governmentForm = governmentForm; }
}

