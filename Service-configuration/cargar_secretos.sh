#!/bin/bash

# Salir si hay errores
set -e

# Lista explícita de secretos
declare -a SECRETS=(
  "GestVuelos-ms"
  "Reservas-ms"
  "Notificaciones-ms"
  "Usuarios-ms"
  "GestHoteles-ms"
)

echo "🚀 Subiendo secretos a Vault..."

for service in "${SECRETS[@]}"; do
  file="${service}.json"
  
  if [[ -f "$file" ]]; then
    echo "🔐 Subiendo: secret/${service} desde ${file}"
    vault kv put "secret/${service}" @"${file}"
    echo "✅ Secreto cargado: ${service}"
  else
    echo "⚠️  Archivo no encontrado: ${file} — omitido"
  fi
done

echo "🎉 Todos los secretos han sido procesados."
