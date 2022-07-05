# Autoscaner

1)Для локального запуска выбрать рабочую директорию src<br>

2)При первом запуске в AutoScannerService над методом scan повесить аннотацию @PostConstruct (отом закоментировать)

3)Пример запроса поиска по критериям<br> 
````
{
    "fromYear": 2000,
    "toYear": 2020,
    "fromPrice": 10000,
    "toPrice": 200000,
    "make": "BMW",
    "modelId": 585
}
