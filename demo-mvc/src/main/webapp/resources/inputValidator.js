	/* Check if answer is mandatory for a question */
    function isInputMandatory() {
        var questionElement = $("#question");
        if (questionElement !== null) {
            var classArray = questionElement.attr("class").split(" ");
            var index = $.inArray("answer-required", classArray);
            return (index >= 0);
        }
        return false;
    }

	/* Return the id of alert box */
    function getAlertBox() {
        return $("#alert-box");
    }

	/* Checks input to see if when answer is required answer, it is provided. */
    function checkInput() {
        var validity = true;
        if (isInputMandatory())    {
            optionElement = $("#option");
            if (optionElement !== null)  {
                var tagName = optionElement[0].tagName;
                if (tagName === "INPUT") {
                    var elementType = optionElement.attr("type").toLowerCase();
                    if (elementType === "text") {
                        validity = optionElement.val() !== "";    
                    } else {
                        validity = false;
                    }
                } else if (tagName === "SELECT") {
                    validity = optionElement.val() !== "";
                } else if (tagName === "FIELDSET") {
                	validity = false;
                	//Same check applies for checkbox and radio button
                	$.each(optionElement.children("input"), function (index, value){
                		validity = validity || value.checked;
                	});
                } else {
                    validity = false;
                }
            }
            if (!validity) {
                var alertBox = getAlertBox();
                if (alertBox !== null) {
                    alertBox.html("This question needs an answer");
                }
            }
            console.log("Validity of input is " + validity);
            return validity;
        }
    }
