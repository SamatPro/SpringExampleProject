<!doctype html>
<html lang="en" xmlns:th="http://www.thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Войти</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<nav  class="navbar navbar-expand-lg bg-body-tertiary"></nav>
<div class="container mt-5">
    <div class="col-md-5 mx-auto">
        <h2 class="text-center my3">Войти</h2>
        <form action="/signup" method="post">
            <div class="row">
                <div class="mb-3 col-sm-6">
                    <label class="form-label">Логин</label>
                    <input name="login" type="text" class="form-control" placeholder="Логин">
                </div>
                <div class="mb-3 col-sm-6">
                    <label class="form-label">Пароль</label>
                    <input name="password" type="password" class="form-control">
                </div>
            </div>
            <div class="mb-3">
                <label class="form-label"></label>
                <input type="submit" class="form-control btn btn-primary" value="Войти">
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>