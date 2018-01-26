 $(function () {  
       //check for empty
       function isNotEmpty(val) {
        return ((val !== '') && (val !== undefined) && (val.length > 0) && (val !== null));
    }

    
  $('.jqueryui-marker-datepicker').datepicker({
                dateFormat: "yy-mm-dd",
                changeYear: true,
                changeMonth: true,
                text: false
            });
 });

