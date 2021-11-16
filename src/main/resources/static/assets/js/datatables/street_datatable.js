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
	 
	var $token = $("meta[name='_csrf']").attr("content");
	var $header = $("meta[name='_csrf_header']").attr("content");
	var $street_id = $("#streetId");
	var $street_name =  $("#streetName");
	var $city_id = $("#streetCity");
	var $city_name = $("#streetCity");
	var $form = $("#addStreet");
	var initValidatedForm = validateForm();
	var isValidated = false;
	
	function validateForm(){
		$form.validate({
			rules: {
				streetName: { required: true, minlength: 5 },
				city: {required: true, minlength: 1},
		        streetName: "required",
		        city:"required"
		        	},
		        messages: { streetName: "Попуните назив улице", city:"Изаберите место",},
		        submitHandler: function (form) {
		        	isValidated = checkExistsData(); 
		        	}
		        });
		}
	
	function checkExistsData() {
		var street_name = $street_name.val()
		var city_name = $city_name.find(":selected").text();
		var result = true;
		$('#add-row tr').each(function(i, el){
			var street = $(el).children().eq(1).text();
			var city = $(el).children().eq(2).text();
			if(street == street_name && city == city_name ){
				console.log("Postoji slog sa istim vrednostima u tabeli.");
				result = false;
				}
			});
		if(result == false){
			popUpError(street_name, city_name);
			}
		return result;
	}
	
   $('#addStreet').submit(function(event) {
		event.preventDefault();
		validateForm()
		if(isValidated) {
			var formData= {streetId : $street_id.val(),name : $street_name.val(),
					city: {cityId: $city_id.val()}}
			ajaxPost(formData);
			isValidated = false;
			}
		});
	
   function ajaxPost(formData, xhr) {
		$.ajax({
			type: 'POST',
			beforeSend: function(xhr) {
				xhr.setRequestHeader($header, $token);
				},
				url: '/user/street/saveStreet',
				contentType: "application/json; charset=utf-8",
				dataType : 'json',
				xhrFields: {withCredentials: true},
                header: {'Content-Type': 'application/json'},
                traditional: true,
		        data : JSON.stringify(formData),
		        success : function(data) {
		        	removeFromTableById($street_id.val())
		            addToDataTable(data);
		        	$street_id.val("")
		           },
		        error : function(e) {
		        	alert(e)
		        	console.log("ERROR: ", e);
		        	}
		        });
		}
	

	function addToDataTable(data) {
		var action = '<td><div class="form-button-action"> <button type="button" data-target="#addRowModal" data-id=' + '"' + data.streetId+'"' +'data-street='+'"'+data.name +'"'  +'data-city=' + '"'+data.city.cityId+'"' + 'data-toggle="modal" title="Уреди" class="btn btn-link btn-primary btn-lg" data-original-title="Edit Task"> <i class="fa fa-edit"></i> </button> <button type="button" data-id=' + '"' + data.streetId+'"' +'data-street='+'"'+data.name +'"'  +'data-city=' + '"'+data.city.cityId+'"' + '  data-toggle="modal"   title="Избриши" class="btn btn-link btn-danger" data-original-title="Remove"> <i class="fa fa-times"></i> </button> </div> </td>';
		$('#add-row').dataTable().fnAddData([
			data.streetId,
			data.name,
			data.city.name,
			action
			]);
		$('#addRowModal').modal('hide');
		if($street_id.val() != ""){
			notification("top", "center", "success", "fa fa-check", "Ажурирање обављено", "Улица успешно ажурирана." )
		}else{
			notification("top", "center", "success", "fa fa-check","Креирање обављено", "Улица "+data.name+" успешно додата.")
			}
	}
	
	$('#add-row').dataTable().on("click",".btn-lg", function(){
		var id = $(this).attr("data-id")
        var street = $(this).attr("data-street")
		var city = $(this).attr("data-city")
		$("#streetId").val(id);
		$("#streetName").val(street);
		$("#streetCity").val(city);
		});
	
	
	
	function popUpError(street, city){
		swal("Грешка", "Улица " + street + " у месту " + city + " већ постоји!", {
			icon : "error",
			buttons: {        			
				confirm: {
					className : 'btn btn-danger'
				}
			},
		});
		
	}
	
	function notification(from, align, state, icon, title, message){
		var content = {};
        content.message = message;
		content.title = title;
	    content.icon = icon;
		//content.url = '';
		//content.target = '_blank';
		$.notify(content,{
			type: state, //"success"
			placement: {
				from: from, //"top" 
				align: align //"center"
			},
			time: 1000,
			delay: 5000,
			});
		}
	
	
	function removeFromTableById(street_id){
		var table = $('#add-row').DataTable();
		$('#add-row tr').each(function(i, el){
			var id_t = $(el).children().eq(0).text();
			if(id_t == street_id){
				console.log("Update tabele");
				table.row($(el)).remove().draw();
			}
			});
		}
	$("#addRowModal").on("hidden.bs.modal", function(){
		$(this).find('form').trigger('reset');
		});
	
	//Delete street
	$('#add-row').dataTable().on("click",".btn-danger", function(){
		var id = $(this).attr("data-id")
        var street = $(this).attr("data-street")
		var city = $(this).attr("data-city")
		swal({
			title: 'Брисање',
			text: "Да ли желите да обришете улицу " + street,
			type: 'warning',
			buttons:{confirm: {text : 'Да, обриши!',className : 'btn btn-success'},
				     cancel: {visible: true, text: 'Одустани', className: 'btn btn-danger'}
			}
		}).then((Delete) => {
			if (Delete) {
				ajaxGet(id)
				notification("top", "center", "success", "fa fa-check", "Успешно обрисано", "Улица " + street+ " је успешно обрисана")
			} else {
				swal.close();
			}
		});
		
	});
	
	function ajaxGet(params,xhr) {
		$.ajax({
			type: 'GET',
			beforeSend: function(xhr) {
				xhr.setRequestHeader($header, $token);
				},
			xhrFields: {withCredentials: true},
			url: '/user/street/delete',
			data: { 
				streetId: params
				},
			success : function(data) {
				removeFromTableById(params);
				},
		    error : function(e) {
		    	alert(e)
		    	console.log("ERROR: ", e);
		    	}
			});
		}
	
	
	
	
	
	
});





