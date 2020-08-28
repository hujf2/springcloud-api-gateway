# 网关的json
````
[
    {
       "id": "aliyun_route","uri":"https://www.aliyun.com/","order": 0,
       "filters": [],
       "predicates": 
       [{"args": {"pattern":"/product/**"},"name":"Path"}]
    },
    {
       "id": "aliyun_route1","uri":"https://www.aliyun.com/","order": 0,
       "filters": [],
       "predicates": 
       [{"args": {"pattern":"/product1/**"},"name":"Path"}]
    }
    ,
    {
       "id": "aliyun_route2","uri":"lb://microservice-dingding","order": 0,
       "filters": [],
       "predicates": 
       [{"args": {"pattern":"/dingding-service/**"},"name":"Path"}]
    }
    ,
    {
       "id": "aliyun_route3","uri":"http://118.190.113.32:8848/","order": 0,
       "filters": [],
       "predicates": 
       [{"args": {"pattern":"/nacos/**"},"name":"Path"}]
    }
]

````
