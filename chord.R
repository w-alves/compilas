```{r}


library(circlize)
mat1 = matrix(rnorm(25), nrow = 5)
rownames(mat1) = paste0("D_A", 1:5)
colnames(mat1) = paste0("D_B", 1:5)

mat2 = matrix(rnorm(25), nrow = 5)
rownames(mat2) = paste0("D_A", 1:5)
colnames(mat2) = paste0("D_C", 1:5)

mat3 = matrix(rnorm(25), nrow = 5)
rownames(mat3) = paste0("D_B", 1:5)
colnames(mat3) = paste0("D_C", 1:5)

mat = matrix(0, nrow = 10, ncol = 10)
rownames(mat) = c(rownames(mat2), rownames(mat3))
colnames(mat) = c(colnames(mat1), colnames(mat2))
mat[rownames(mat1), colnames(mat1)] = mat1
mat[rownames(mat2), colnames(mat2)] = mat2
mat[rownames(mat3), colnames(mat3)] = mat3
mat

nm = unique(unlist(dimnames(mat)))

```


```{r}


library(circlize)
mat1 = matrix(rbinom(25, 2, 0.3), nrow = 5)
rownames(mat1) = paste0("D_A", 1:5)
colnames(mat1) = paste0("D_B", 1:5)

mat2 = matrix(rbinom(25, 2, 0.3), nrow = 5)
rownames(mat2) = paste0("D_A", 1:5)
colnames(mat2) = paste0("D_C", 1:5)

mat3 = matrix(rbinom(25, 2, 0.3), nrow = 5)
rownames(mat3) = paste0("D_B", 1:5)
colnames(mat3) = paste0("D_C", 1:5)

mat = matrix(0, nrow = 10, ncol = 10)
rownames(mat) = c(rownames(mat2), rownames(mat3))
colnames(mat) = c(colnames(mat1), colnames(mat2))
mat[rownames(mat1), colnames(mat1)] = mat1
mat[rownames(mat2), colnames(mat2)] = mat2
mat[rownames(mat3), colnames(mat3)] = mat3
mat

nm = unique(unlist(dimnames(mat)))

```

```{r} 
library(svglite)




circos.clear()

grid.col = c(D_C2 = "blue", D_B2 = "green", D_C3 = "blue", D_B1 = "green", D_A1 = "red", D_B3 = "green", D_A3 = "red", D_C1 = "blue", D_A2 = "red")

group = structure(gsub("\\d", "", nm), names = nm)
chordDiagram(mat, group = group, grid.col = grid.col,
    annotationTrack = c("grid"),
    preAllocateTracks = list(
        track.height = mm_h(4),
        track.margin = c(mm_h(4), 0)
))


circos.track(track.index = 2, panel.fun = function(x, y) {
    sector.index = get.cell.meta.data("sector.index")
    xlim = get.cell.meta.data("xlim")
    ylim = get.cell.meta.data("ylim")
    circos.text(mean(xlim), ylim[1] + 2, sector.index, cex = 0.6, col='white', facing = "clockwise", niceFacing = TRUE, adj = c(0, 0.8))
}, bg.border = NA)

highlight.sector(c('D_C3', 'D_B1'), track.index = 1, col = '#fff100', 
 text = 'Projeto A', cex = 0.8, text.col = 'white', niceFacing = TRUE, )
highlight.sector(c('D_C4', 'D_B4', 'D_B5'), track.index = 1, col = '#ff8c00', 
 text = 'Projeto B', cex = 0.8, text.col = 'white', niceFacing = TRUE)
highlight.sector(c('D_A4'), track.index = 1, col = '#e81123', 
 text = 'Projeto C', cex = 0.8, text.col = 'white', niceFacing = TRUE)
highlight.sector(c('D_A1', 'D_A3'), track.index = 1, col = '#ec008c', 
 text = 'Projeto D', cex = 0.8, text.col = 'white', niceFacing = TRUE)
highlight.sector(c('D_B3', 'D_B2'), track.index = 1, col = '#68217a', 
 text = 'Projeto E', cex = 0.8, text.col = 'white', niceFacing = TRUE)
highlight.sector(c('D_A2', 'D_C1', 'D_C2'), track.index = 1, col = '#00188f', 
 text = 'Projeto F', cex = 0.8, text.col = 'white', niceFacing = TRUE)
highlight.sector(c('D_C5'), track.index = 1, col = '#00bcf2', 
 text = 'Projeto G', cex = 0.8, text.col = 'white', niceFacing = TRUE)
highlight.sector(c('D_A5'), track.index = 1, col = '#00b294', 
 text = 'Projeto I', cex = 0.8, text.col = 'white', niceFacing = TRUE)


```
