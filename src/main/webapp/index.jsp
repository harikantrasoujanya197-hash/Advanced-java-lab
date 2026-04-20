<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Form</title>

<script>
function validateForm() {
    let f = document.forms["form1"];

    if(f.roll.value=="" || f.name.value=="" ||
       f.sub1.value=="" || f.sub2.value=="" ||
       f.sub3.value=="" || f.sub4.value=="" ||
       f.sub5.value=="") {
        alert("All fields must be filled");
        return false;
    }

    let marks = [f.sub1.value,f.sub2.value,f.sub3.value,f.sub4.value,f.sub5.value];

    for(let i=0;i<marks.length;i++){
        if(marks[i] < 0 || marks[i] > 100){
            alert("Marks must be between 0 and 100");
            return false;
        }
    }

    return true;
}
</script>

</head>
<body>

<div style="width:300px;margin:50px auto;border:1px solid #ccc;padding:20px;">
<h2>Student Details</h2>

<form name="form1" action="processResult" method="POST" onsubmit="return validateForm()">

Roll No : <input type="text" name="roll"><br><br>
Name : <input type="text" name="name"><br><br>

Sub1 : <input type="number" name="sub1"><br><br>
Sub2 : <input type="number" name="sub2"><br><br>
Sub3 : <input type="number" name="sub3"><br><br>
Sub4 : <input type="number" name="sub4"><br><br>
Sub5 : <input type="number" name="sub5"><br><br>

<input type="submit" value="Submit">

</form>
</div>

</body>
</html>