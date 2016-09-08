// States
var state_arr = new Array("TamilNadu", "Kerela", "Karnataka", "AndhraPradesh");

// Cities
var s_a = new Array();
s_a[0] = "";
s_a[1] = "Chennai|Coimbatore|Salem|Kumbakonam";
s_a[2] = "Kochi|Alappuzha|Thrissur|Calicut";
s_a[3] = "Bengaluru|Mysore|Mangalore|Hubli";
s_a[4] = "Tirupathi|Kadapa|Adoni|Vijayawada";

function populateCities(stateElementId, cityElementId) {

    var selectedStateIndex = document.getElementById(stateElementId).selectedIndex;

    var cityElement = document.getElementById(cityElementId);

    cityElement.length = 0; // Fixed by Julian Woods
    cityElement.options[0] = new Option('Select brand', '');
    cityElement.selectedIndex = 0;

    var city_arr = s_a[selectedStateIndex].split("|");

    for (var i = 0; i < city_arr.length; i++) {
        cityElement.options[cityElement.length] = new Option(city_arr[i], city_arr[i]);
    }
    
}

function populateStates(stateElementId, cityElementId) {
    // given the id of the <select> tag as function argument, it inserts <option> tags
    var stateElement = document.getElementById(stateElementId);
    stateElement.length = 0;
    stateElement.options[0] = new Option('Select Loan type', '-1');
    stateElement.selectedIndex = 0;
    for (var i = 0; i < state_arr.length; i++) {
        stateElement.options[stateElement.length] = new Option(state_arr[i], state_arr[i]);
    }

    // Assigned all states. Now assign event listener for the cities.

    if (cityElementId) {
        cityElement.onchange = function () {
            populateStates(stateElementId, cityElementId);
        };
    }
}
