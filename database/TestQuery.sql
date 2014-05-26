SELECT a.Name as Name, a.Description as Description, a.ImageURL as URL, f.Name as FlagName, f.Description as FlagDescription, i.Name as IngredientName, f2.Name as IngredientFlagName, f2.Description as IngredientFlagDescription
FROM 
ARTICLE a
LEFT JOIN ARTICLE_FLAGS af ON a.ID = af.FK_ArticleID
LEFT JOIN ARTICLE_INGREDIENTS ai ON a.ID = ai.FK_ArticleID
LEFT JOIN INGREDIENT i ON ai.FK_IngredientID = i.ID
LEFT JOIN INGREDIENT_FLAGS iflags on i.ID = iflags.FK_IngredientID
LEFT JOIN FLAG f2 ON iflags.FK_FlagID = f2.ID
LEFT JOIN FLAG f ON af.FK_FlagID = f.ID
WHERE a.ID = 3045320092066;