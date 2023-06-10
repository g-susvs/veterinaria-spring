const d = document;
const $inputFile = d.getElementById("input-file");
const $imgUpload = d.getElementById("img-upload");
const $idVet = d.getElementById("id_vet");
const formData = new FormData();
const $spinner = d.querySelector(".spinner-loader");

// valor se obtiene cuando subo la imagen a cloudinay
let secure_url;

$inputFile.addEventListener("change", (e) => {
  formData.append("archivo", $inputFile.files[0]);
  const reader = new FileReader();

  reader.onload = function (e) {
    $imgUpload.src = e.target.result;
    $imgUpload.style.width = "250px";
    $imgUpload.style.height = "200px";
  };

  reader.readAsDataURL($inputFile.files[0]);
});

d.addEventListener("submit", (e) => {
  e.preventDefault();
  // Mostrar loader
  $spinner.classList.remove("none");

  uploadFile($idVet.textContent, formData);
});

const uploadFile = async (id, formData) => {
  try {
    const resp = await fetch(
      `http://localhost:8080/api/veterinaria/actualizarimg/${id}`,
      {
        method: "PUT",
        body: formData,
      }
    );

    const data = await resp.json();
    if (data.error) {
      console.error(data);
      console.error("Fallo");
      Swal.fire({
        title: "Error!",
        text: "No has enviado imagen",
        icon: "error",
        confirmButtonText: "Ok",
      });
      $spinner.classList.add("none");
      return null;
    }
    // Quitar loader
    $spinner.classList.add("none");
    const alerta = await Swal.fire({
      title: "Listo!",
      text: "La imagen a sido asignada",
      icon: "success",
      confirmButtonText: "Volver al inicio",
      allowOutsideClick: false,
    });

    if (alerta.isConfirmed) {
      location.replace("http://localhost:8080/");
    }
  } catch (error) {
    console.log(error);
  }
};
