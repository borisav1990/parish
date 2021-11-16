$(document).ready(function() {
	
	$('#add-row').DataTable({
		order: [[0, 'desc']],
		"pageLength": 5,
		language: {
			'search' : 'Претражи: ',
			'sLengthMenu': 'Прикажи _MENU_ колона у табели',
			"info": "Приказано _START_ - _END_  од укупно _TOTAL_ улица.",
			}
	});
	
	var options_id = [];
	var options_name = [];

	$( '.dropdown-menu a' ).on( 'click', function( event ) {
      
	   var $target = $( event.currentTarget ),
	       val = $target.attr( 'patron_id' ),
	       $inp = $target.find( 'input' ),
	       idx;
       if ( ( idx = options_id.indexOf( val ) ) > -1 ) {
	      options_id.splice( idx, 1 );
	      options_name.splice( idx, 1 );
	      setTimeout( function() { $inp.prop( 'checked', false ) }, 0);
	     
	   } else {
	      options_id.push(val);
	      options_name.push($target.attr('patron_name') );
	      setTimeout( function() { $inp.prop( 'checked', true ) }, 0);
	     }

	   $( event.target ).blur();
	   if (options_id.length > 0){
		   $(".patronSelBtn").html(options_name[0]);
		   
	   }else{
		   $(".patronSelBtn").html("Изаберите славу")
	   }
	   console.log( options_name );
	   return false;
	});
	
});
