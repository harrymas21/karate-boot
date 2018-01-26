 $(function () {
     //logout function with ajax
       $('#logout').on('click', function () {
           $.ajax({
                type: 'POST',
                url: '/app-logout',
                success: function (data) {}
            });
       }); 
 });

