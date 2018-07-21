This is an example of the combination between [Spring Boot](https://spring.io/projects/spring-boot), [GraphQL](https://graphql.org/) and [PostgreSQL](https://www.postgresql.org/).

* Java: **1.8.0**
* Spring Boot: **2.0.3**
* GraphQL Java: **9.0**
* Application port: **8090**

* PostgreSQL: **10**
* DB Name: **metal-archives**
* DB Port: **5432**
* DB User/Pass: **postgres**

* There is a SQL(data.sql) file with the data used to run this project. You can use this file to populate your database.

---

Queries examples:

**Method**: POST
**URL**: http://localhost:8090/rest/artist    

    query {
        artist(id: 23) {
            name,
            age,
            bands {
                name
            }
        }
    }


    query {
        allArtists {
            name
        }
    }


    query {
        allArtists {
            name,
            age,
            roles {
                name
            },
            bands {
                name,
                country {
                    name
                }
            }
        }
    }


    query {
        allBands {
            name,
            country {
                name
            },
            members {
                name
                roles {
                    name
                }
            }
        }
    }

