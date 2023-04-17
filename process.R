```{r}
M = read.csv("mat.csv")
M = data.frame(M[,-1], row.names = M[,1])
mat = data.matrix(M)
```

```{r}
M$nonzeros <- simplify2array(
                      apply(
                        M[1:4], 1, 
                        function(x) paste(names(M[1:4])[x != 0], collapse = " ")
                      )
                )
```
