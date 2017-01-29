$('#modalExclusao').on(
		'show.bs.modal',
		function(event) {

			var button = $(event.relatedTarget);

			var codigoTitulo = button.data('codigo');
			var descricaoTitulo = button.data('descricao');

			var modal = $(this);

			var form = modal.find('form');
			var action = form.data('url-base');

			if (!action.endsWith('/')) {
				action += '/';
			}

			form.attr('action', action + codigoTitulo);

			modal.find('.modal-body span').html(
					'Tem certeza que deseja excluir o título <strong>'
							+ descricaoTitulo + '</strong> ?');

		});

$(function() {
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({
		decimal : ',',
		thousands : '.',
		allowZero : true
	});
	
	$('.js-atualizar-status').on('click', function(event){
		
		// não deixa exibir a url do link na barra de endereço
		event.preventDefault();
		
		var botaoReceber =$(event.currentTarget);
		
		var urlReceber = botaoReceber.attr('href');
		
		var response = $.ajax({
			
			url: urlReceber,
			type: 'PUT'
		});
		
		response.done(function(e){
			var codigoTitulo = botaoReceber.data('codigo');
			$('[data-rule=' + codigoTitulo+']').html('<span class="label label-success">'+ e +'</span>'); //seletor
			botaoReceber.hide();
		});
		
		
		response.fail(function (e){
			alert("falhou >>>" + e);
			console.log("falhou >>>" + e);
		});
		
	});
});

