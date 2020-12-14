<html>
<head>
    <title>Employee</title>
</head>
<body>
    accept-language: ${header['accept-language']}
    <br/>
    session id: ${pageContext.session.id}
    <br/>
    employee: ${requestScope.employee.name}, ${employee.address.city}
    <br/>
    capital: ${capitals["Canada"]}
</body>
</html>