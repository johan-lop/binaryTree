# Binary Tree
Find lowest common ancestor
## Stack
- SpringBoot
- Maven
## How to run
In console execute 
```
mvn install
mvn test
mvn spring-boot:run
```

## Api Reference 

### 1. Create a binary tree (POST)
> Send a Json tree and obtain a graph of this tree
> 
> http://localhost:8080/api/tree

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

Output example 

```
67
├───39
│  ├───28
│  │  └───29
│  └───44
└───76
   ├───74
   └───85
      ├───83
      └───87
```

### 2. Find the lowest ancestor (POST)
> Send a Json tree and two nodes and obtain a graph and the lowest common ancestor
>
> http://localhost:8080/api/tree/lowerCommonAncestor

Input Example
```
{
    "tree": {
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
    },
    "firstNode": 29,
    "secondNode": 44
}
```

Output example

```
{
    "graph": "67\n├───39\n│  ├───28\n│  │  └───29\n│  └───44\n└───76\n   ├───74\n   └───85\n      ├───83\n      └───87",
    "lowestCommonAncestor": 39
}
```