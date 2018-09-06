"use strict";

function divHover(element) {
    element.className = "callout primary border-none";
    // console.log(element.className)
}

function divNorm(element) {
    element.className = "callout secondary border-none";
    // console.log(element.className)
}

document.addEventListener("DOMContentLoaded", () => {
    const frm1 = document.forms.form1;
    frm1.onsubmit = (event) => {
        event.preventDefault();
        if (mustHaveCheck >= 3) {
            swal("Пользователь успешно зарегестрирован!", "А теперь входите под ним в систему...", "success")
            // https://sweetalert.js.org/guides/
                .then(() => frm1.submit())
            ;
        }
        if (mustHaveCheck < 3) {
            swal("Не все поля заполнены!", "Обязательно ввести E-Mail, и пароль. Не забудьте его подтвердить.", "error");
        } return null;
    };


    let mustHaveCheck = 0;
    console.log(frm1.elements.email);
    const elemInput1 = frm1.elements.email;
    const elemInput2 = frm1.elements.password;
    const elemInput3 = frm1.elements.passwordTwo;
    const maxCountPassword = 4;

    elemInput1.onmouseup = checkInput1;
    elemInput1.onblur = checkInput1;
    elemInput2.onmouseup = checkInput2;
    elemInput2.onblur = checkInput2;
    elemInput3.onmouseup = checkInput3;
    elemInput3.onblur = checkInput3;


    divNorm(document.getElementById('divInput1'));

    function mySubmit() {
        mustHaveCheck = 0;
        checkInput1();
        checkInput2();
        checkInput3();
    }


    async function checkInput1() {
        const elemInput1 = frm1.elements.email;
        const at = elemInput1.value.indexOf("@");
        const dot = elemInput1.value.indexOf(".");
        if (elemInput1.value.length === 0) {
            document.getElementById("input1Error").innerHTML = "*данное поле обязательно для заполнения действующим E-mail";
            return false;
        }
        if (at < 1 || dot < 1) {
            document.getElementById("input1Error").innerHTML = "*email введен не верно, НЕОБХОДИМА РЕАЛЬНАЯ ПОЧТА";
            return false;
        }
        document.getElementById("input1Error").innerHTML = "";


        const isEmail = await fetch(getUrl() + "/api/email",
            {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify({email: elemInput1.value})
            }).then(res => res.json());
        console.log(isEmail);
        if (isEmail) {
            document.getElementById("input11Error").innerHTML = "";
            document.getElementById("input1Error").innerHTML = "Такой пользователь уже зарегестрирован!";
            return false;
        }
        document.getElementById("input1Error").innerHTML = "";
        document.getElementById("input11Error").innerHTML = "Этот логин свободен!";
        mustHaveCheck++;
        return true;
    }

    function checkInput2() {
        if (elemInput2.value.length < maxCountPassword && elemInput2.value.length > 0) {
            document.getElementById("input2Error").innerHTML
                = "* пароль должен быть " + maxCountPassword + " символа минимум, вы же ввели " + elemInput2.value.length;
            return false;
        }
        if (elemInput2.value.length === 0) {
            document.getElementById("input2Error").innerHTML
                = "*данное поле обязательно для заполнения (" + maxCountPassword + " символа минимум)";
            return false;
        }
        document.getElementById("input2Error").innerHTML = "";
        mustHaveCheck++;
        return true;
    }

    function checkInput3() {
        if (elemInput3.value.length === 0) {
            document.getElementById("input3Error").innerHTML = "* данное поле не должно остаться пустым";
            return false;
        }
        if (elemInput3.value.length < maxCountPassword) {
            document.getElementById("input3Error").innerHTML = "* поле не должно быть меньше " + maxCountPassword + " символа";
            return false;
        }
        if (elemInput2.value !== elemInput3.value) {
            document.getElementById("input3Error").innerHTML = "* пароль должен совпадать с введенным в предыдущее поле";
            return false;
        }
        document.getElementById("input3Error").innerHTML = "";
        mustHaveCheck++;
        return true;
    }
});


