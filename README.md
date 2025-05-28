# 📦 Tracking Number Service

### 🚀 Deploying to Railway

1. Go to [Railway](https://railway.app)
2. Create a new project and link your GitHub repo
3. Add a **PostgreSQL plugin** (Railway will auto-configure the database)
4. Set the following Environment Variables in your project:
   - `DB_URL`
   - `DB_USER`
   - `DB_PASSWORD`
   - `PORT` = `8080`
5. Push your code to GitHub — Railway will auto-deploy the app and expose a public URL.

### 🧪 API Endpoint

```http
GET /api/v1/next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2023-01-01T12:00:00Z&customer_id=UUID&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics
```

### ✅ Response Format

```json
{
  "tracking_number": "ABC123XYZ",
  "created_at": "2023-01-01T12:00:00Z"
}
```