(function() {
    document.addEventListener("DOMContentLoaded",() => {
        for (type of ["Insert","Delete","Select","Update"]) {
            let ele =  document.querySelector(type === "Insert" ? "#insertFields" : "#"+type.toLowerCase()+"Fields fieldset");
            let type_ = type;
            document.querySelector("#add"+type).addEventListener("click",
            () => ele.appendChild(type_==="Insert" ? ele.firstElementChild.cloneNode(true) : ele.children[1].cloneNode(true)));
        }
    })
})();