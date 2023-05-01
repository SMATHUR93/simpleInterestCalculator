# simpleInterestCalculator
Java Spring Boot Microservice for Simple Interest Calculation

Simple Java Spring boot application.
Architecture is MVC.
1. Controller.
2. Service
3. Repository (aka DAO)
4. Entity

Endpoints:

From SImple Interest Service:

> I/P: http://localhost:5001/simple-interest?principal=1000&rate=5&time=2
> 
> O/P: 100

> Inter API communication: http://localhost:5001/simple-interest/compound-interest?principal=1000&rate=5&time=2


From Compound Interest Service:

> I/P: http://localhost:5002/compound-interest?principal=1000&rate=5&time=2
>
> O/P: 1051.27

From Profit and Loss Service:

> I/P: http://localhost:5003/profit-and-loss?costPrice=500&sellingPrice=700
> 
> O/P: 200.0

Docker commands utilized:

Docker Image Creation
> docker build --tag simple-interest-calculator .

Docker Network Creation
> docker network create my-network

Docker run container on network
> docker run --network my-network -p 5001:5001 <IMAGE_ID>

Architecture Diagram:

```

+----------------------+     +------------------------+     +-----------------------+
|                      |     |                        |     |                       |
| Simple Interest (SA) |     | Compound Interest (SB)  |     |  Profit and Loss (SC) |
|                      |     |                        |     |                       |
+----------+-----------+     +------------+-----------+     +-----------+-----------+
           |                               |                             |
           |                               |                             |
           |                               |                             |
           +---------------+---------------+---------------+-------------+
                           |                               |
                           |                               |
                           |                               |
                           |                               |
            +--------------v---------------+   +-------------v---------------+
            |                              |   |                             |
            |         SA- SB Communication |   |        SA-SC Communication  |
            |                              |   |                             |
            +--------------+---------------+   +-------------+---------------+
                           |                               |
                           |                               |
                           |                               |
                           |                               |
+----------------------+   |   +----------------------+   |   +----------------------+
|                      |   |   |                      |   |   |                      |
|      SA API          |   |   |      SB API          |   |   |      SC API          |
|      (Port: 8080)    |   |   |      (Port: 8081)    |   |   |      (Port: 8082)    |
|                      |   |   |                      |   |   |                      |
+----------------------+   |   +----------------------+   |   +----------------------+


```



Deployment Diagram:

```

+-----------------------+       +-----------------------+       +-----------------------+
|                       |       |                       |       |                       |
| Simple Interest (SA)  |       | Compound Interest (SB) |       | Profit and Loss (SC)  |
|                       |       |                       |       |                       |
| Docker Container      |       | Docker Container      |       | Docker Container      |
| Port: 8080            |       | Port: 8081            |       | Port: 8082            |
+-----------------------+       +-----------------------+       +-----------------------+


```
