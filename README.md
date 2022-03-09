# Binary Tree
Find lowest common ancestor

## Stack
-SpringBoot
-Maven

## How to run
In console execute 
```
mvn install
mvn run
```

## Api Reference 

> Create an binary tree
> POST localhost:8080/api/tree

Input Example
```
{
    "root": {
        "value": 67,
        "leftNode": {
            "value": 39,
            "leftNode": {
                "value": 28,
                "rightNode": {
                    "value": 29
                }
            },
            "rightNode": {
                "value": 44
            }
        },
        "rightNode": {
            "value": 76,
            "leftNode": {
                "value": 74
            },
            "rightNode": {
                "value": 85,
                "leftNode": {
                    "value": 83
                },
                "rightNode": {
                    "value": 87
                }
            }
        }
    }
}
```
