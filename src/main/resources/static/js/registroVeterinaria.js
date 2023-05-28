const d = document;

const $form = document.getElementById("vet-form");

$form.addEventListener("submit", e => {
    e.preventDefault()

    const form = new FormData($form)

    const body = {
        nombre: form.get('nombre'),
        correo: form.get('correo'),
        descripcion: form.get('descripcion'),
        direccion: form.get('direccion'),
        imagen: form.get('imagen'),
    }
    registrarVet(body);
})

const registrarVet = async (body) => {
    try {
        const resp = await fetch('http://localhost:8080/api/veterinaria',{
            method:'POST',
            headers: {
                'Content-Type': 'application/json'
              },
            body: JSON.stringify(body)
        })

        const data = await resp.json();

        if(data.nombre){
            console.log(`Se registro la veterinaria ${data.nombre}`)
        }
        
    } catch (error) {
        console.log(error)   
    }
}