function onLoad() {
	var app = new Vue(
		{
			el : '#atividades',
			data : {
				atividades : []
			},
			mounted(){
				axios
					.get('http://localhost:8080/api/atividade')
					.then(response => (this.atividades = response.data))
			}
		});

}
