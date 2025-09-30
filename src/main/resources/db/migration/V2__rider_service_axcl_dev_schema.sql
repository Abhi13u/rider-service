-- --
-- -- -- PostgreSQL database dump
-- --

-- -- Dumped from database version 17.4
-- -- Dumped by pg_dump version 17.0

-- -- Started on 2025-09-29 19:07:08 EDT

-- SET statement_timeout = 0;
-- SET lock_timeout = 0;
-- SET idle_in_transaction_session_timeout = 0;
-- SET transaction_timeout = 0;
-- SET client_encoding = 'UTF8';
-- SET standard_conforming_strings = on;
-- SELECT pg_catalog.set_config('search_path', '', false);
-- SET check_function_bodies = false;
-- SET xmloption = content;
-- SET client_min_messages = warning;
-- SET row_security = off;

-- --
-- -- TOC entry 8 (class 2615 OID 18395)
-- -- -- Name: axcl_dev; Type: SCHEMA; Schema: -; Owner: postgres
-- --

-- CREATE SCHEMA public;


-- -- ALTER SCHEMA public OWNER TO postgres;

-- SET default_tablespace = '';

-- SET default_table_access_method = heap;

-- --
-- -- TOC entry 273 (class 1259 OID 18396)
-- -- -- Name: databasechangelog; Type: TABLE; Schema: axcl_dev; Owner: postgres
-- --

CREATE TABLE databasechangelog (
    id character varying(255) NOT NULL,
    author character varying(255) NOT NULL,
    filename character varying(255) NOT NULL,
    dateexecuted timestamp without time zone NOT NULL,
    orderexecuted integer NOT NULL,
    exectype character varying(10) NOT NULL,
    md5sum character varying(35),
    description character varying(255),
    comments character varying(255),
    tag character varying(255),
    liquibase character varying(20),
    contexts character varying(255),
    labels character varying(255),
    deployment_id character varying(10)
);


-- ALTER TABLE databasechangelog OWNER TO postgres;

--
-- TOC entry 274 (class 1259 OID 18401)
-- -- Name: databasechangeloglock; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE TABLE databasechangeloglock (
    id integer NOT NULL,
    locked boolean NOT NULL,
    lockgranted timestamp without time zone,
    lockedby character varying(255)
);


-- ALTER TABLE databasechangeloglock OWNER TO postgres;

--
-- TOC entry 284 (class 1259 OID 18527)
-- -- Name: m_insurance_providers; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_insurance_providers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE m_insurance_providers (
    id bigint DEFAULT nextval('m_insurance_providers_id_seq'::regclass) NOT NULL,
    insurance_provider_id integer NOT NULL,
    insurance_provider_name character varying(100) NOT NULL
);


-- ALTER TABLE m_insurance_providers OWNER TO postgres;

--
-- TOC entry 290 (class 1259 OID 18587)
-- -- Name: m_service_level_codes; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_service_level_codes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE m_service_level_codes (
    id bigint DEFAULT nextval('m_service_level_codes_id_seq'::regclass) NOT NULL,
    code character varying(20) NOT NULL,
    description character varying(100) NOT NULL
);


-- ALTER TABLE m_service_level_codes OWNER TO postgres;

--
-- TOC entry 286 (class 1259 OID 18547)
-- -- Name: m_trip_acceptance_statuses; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_trip_acceptance_statuses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE m_trip_acceptance_statuses (
    id bigint DEFAULT nextval('m_trip_acceptance_statuses_id_seq'::regclass) NOT NULL,
    acceptance_status_id integer NOT NULL,
    description character varying(100) NOT NULL
);


-- ALTER TABLE m_trip_acceptance_statuses OWNER TO postgres;

--
-- TOC entry 285 (class 1259 OID 18537)
-- -- Name: m_trip_assignment_types; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_trip_assignment_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE m_trip_assignment_types (
    id bigint DEFAULT nextval('m_trip_assignment_types_id_seq'::regclass) NOT NULL,
    assignment_type_code character varying(10) NOT NULL,
    description character varying(100) NOT NULL
);


-- ALTER TABLE m_trip_assignment_types OWNER TO postgres;

--
-- TOC entry 287 (class 1259 OID 18557)
-- -- Name: m_trip_billing_statuses; Type: TABLE; Schema: axcl_dev; Owner: postgres
--


CREATE SEQUENCE m_trip_billing_statuses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE m_trip_billing_statuses (
    id bigint DEFAULT nextval('m_trip_billing_statuses_id_seq'::regclass) NOT NULL,
    status_id integer NOT NULL,
    description character varying(100) NOT NULL
);


-- ALTER TABLE m_trip_billing_statuses OWNER TO postgres;

--
-- TOC entry 292 (class 1259 OID 18607)
-- -- Name: m_trip_cancel_reasons; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_trip_cancel_reasons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE m_trip_cancel_reasons (
    id bigint DEFAULT nextval('m_trip_cancel_reasons_id_seq'::regclass) NOT NULL,
    reason_id integer NOT NULL,
    reason_name character varying(100) NOT NULL
);


-- ALTER TABLE m_trip_cancel_reasons OWNER TO postgres;

--
-- TOC entry 288 (class 1259 OID 18567)
-- -- Name: m_trip_procedure_types; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_trip_procedure_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE m_trip_procedure_types (
    id bigint DEFAULT nextval('m_trip_procedure_types_id_seq'::regclass) NOT NULL,
    type_id integer NOT NULL,
    description character varying(100) NOT NULL
);


-- ALTER TABLE m_trip_procedure_types OWNER TO postgres;

--
-- TOC entry 289 (class 1259 OID 18577)
-- -- Name: m_trip_reasons; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_trip_reasons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE m_trip_reasons (
    id bigint DEFAULT nextval('m_trip_reasons_id_seq'::regclass) NOT NULL,
    reason_id integer NOT NULL,
    reason_name character varying(100) NOT NULL
);


-- ALTER TABLE m_trip_reasons OWNER TO postgres;

--
-- TOC entry 296 (class 1259 OID 18643)
-- -- Name: m_trip_statuses; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_trip_statuses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE m_trip_statuses (
    id bigint DEFAULT nextval('m_trip_statuses_id_seq'::regclass) NOT NULL,
    status_id integer NOT NULL,
    description character varying(100) NOT NULL
);


-- ALTER TABLE m_trip_statuses OWNER TO postgres;

--
-- TOC entry 293 (class 1259 OID 18617)
-- -- Name: m_trip_timestamp_sources; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_trip_timestamp_sources_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE m_trip_timestamp_sources (
    id bigint DEFAULT nextval('m_trip_timestamp_sources_id_seq'::regclass) NOT NULL,
    timestamp_source_id integer NOT NULL,
    description character varying(100) NOT NULL
);

-- ALTER TABLE m_trip_timestamp_sources OWNER TO postgres;

--
-- TOC entry 291 (class 1259 OID 18597)
-- -- Name: m_vehicle_equipment_codes; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE m_vehicle_equipment_codes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE m_vehicle_equipment_codes (
    id bigint DEFAULT nextval('m_vehicle_equipment_codes_id_seq'::regclass) NOT NULL,
    code character varying(10) NOT NULL,
    description character varying(100) NOT NULL
);


-- ALTER TABLE m_vehicle_equipment_codes OWNER TO postgres;

--
-- TOC entry 279 (class 1259 OID 18464)
-- -- Name: o_auth_tokens; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_auth_tokens_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_auth_tokens (
    id bigint DEFAULT nextval('o_auth_tokens_id_seq'::regclass) NOT NULL,
    user_id bigint NOT NULL,
    refresh_token text NOT NULL,
    expires_at timestamp without time zone,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint
);


-- ALTER TABLE o_auth_tokens OWNER TO postgres;

--
-- TOC entry 298 (class 1259 OID 18664)
-- -- Name: o_driver_location; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_driver_location_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_driver_location (
    id bigint DEFAULT nextval('o_driver_location_id_seq'::regclass) NOT NULL,
    driver_id bigint NOT NULL,
    location geometry(Point,4326),
    trip_status_id integer,
    current_trip_id bigint,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint,
    trip_expected_end_time timestamp without time zone
);


-- ALTER TABLE o_driver_location OWNER TO postgres;

--
-- TOC entry 277 (class 1259 OID 18432)
-- -- Name: o_driver_profiles; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_driver_profiles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_driver_profiles (
    id bigint DEFAULT nextval('o_driver_profiles_id_seq'::regclass) NOT NULL,
    user_id bigint NOT NULL,
    sentry_driver_id integer,
    profile_img character varying(100),
    first_name character varying(100) NOT NULL,
    middle_name character varying(100),
    last_name character varying(100) NOT NULL,
    social_security_number character(4) NOT NULL,
    gender integer NOT NULL,
    dob date NOT NULL,
    user_status integer NOT NULL,
    phone_number character varying(15) NOT NULL,
    profile_progress_stage integer,
    address character varying(100),
    city character varying(100),
    state character varying(20),
    zip_code character varying(10),
    country character varying(20),
    lat double precision,
    lng double precision,
    dmv_license_number character varying(30) NOT NULL,
    dmv_state_code character varying(10) NOT NULL,
    dmv_license_class character varying(10) NOT NULL,
    dmv_document_urls text[],
    dmv_effective_date date NOT NULL,
    dmv_expiration_date date NOT NULL,
    dmv_endorsements text[],
    dmv_restrictions text[],
    bg_document_urls text[],
    bg_effective_date date,
    bg_expiration_date date,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint,
    CONSTRAINT chk_dmv_dates CHECK ((dmv_expiration_date > dmv_effective_date)),
    CONSTRAINT o_driver_profiles_user_status_check CHECK ((user_status = ANY (ARRAY[1, 2])))
);


-- ALTER TABLE o_driver_profiles OWNER TO postgres;

--
-- TOC entry 283 (class 1259 OID 18515)
-- -- Name: o_driver_shifts; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_driver_shifts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_driver_shifts (
    id bigint DEFAULT nextval('o_driver_shifts_id_seq'::regclass) NOT NULL,
    driver_id bigint NOT NULL,
    transport_provider_id bigint NOT NULL,
    vehicle_id bigint NOT NULL,
    shift_start_time timestamp without time zone NOT NULL,
    shift_end_time timestamp without time zone NOT NULL,
    is_active boolean DEFAULT true,
    remarks text,
    routing_criterion text,
    start_location_latitude double precision NOT NULL,
    start_location_longitude double precision NOT NULL,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint
);


-- ALTER TABLE o_driver_shifts OWNER TO postgres;

--
-- TOC entry 282 (class 1259 OID 18505)
-- -- Name: o_driver_transport_provider_assignments; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_driver_transport_provider_assignments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_driver_transport_provider_assignments (
    id bigint DEFAULT nextval('o_driver_transport_provider_assignments_id_seq'::regclass) NOT NULL,
    driver_id bigint NOT NULL,
    transport_provider_id bigint NOT NULL,
    vehicle_id bigint,
    assigned_on date NOT NULL,
    is_active boolean,
    remarks text,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint
);


-- ALTER TABLE o_driver_transport_provider_assignments OWNER TO postgres;

--
-- TOC entry 278 (class 1259 OID 18451)
-- -- Name: o_extra_commercial_licenses; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_extra_commercial_licenses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_extra_commercial_licenses (
    id bigint DEFAULT nextval('o_extra_commercial_licenses_id_seq'::regclass) NOT NULL,
    driver_id bigint NOT NULL,
    license_number character varying(30) NOT NULL,
    type_id integer NOT NULL,
    document_urls text[],
    effective_date date NOT NULL,
    expiration_date date NOT NULL,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint
);


-- ALTER TABLE o_extra_commercial_licenses OWNER TO postgres;

--
-- TOC entry 280 (class 1259 OID 18474)
-- -- Name: o_file_uploads_metadata; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_file_uploads_metadata_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_file_uploads_metadata (
    id bigint DEFAULT nextval('o_file_uploads_metadata_id_seq'::regclass) NOT NULL,
    file_name character varying(256) NOT NULL,
    file_path character varying(256) NOT NULL,
    upload_type character varying(256) NOT NULL,
    status integer NOT NULL,
    total_records integer NOT NULL,
    success_count integer NOT NULL,
    failure_count integer NOT NULL,
    errors text,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint
);


-- ALTER TABLE o_file_uploads_metadata OWNER TO postgres;

--
-- TOC entry 276 (class 1259 OID 18419)
-- -- Name: o_transportation_provider_profiles; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_transportation_provider_profiles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_transportation_provider_profiles (
    id bigint DEFAULT nextval('o_transportation_provider_profiles_id_seq'::regclass) NOT NULL,
    user_id bigint NOT NULL,
    company_name character varying(100) NOT NULL,
    lic_number character varying(100) NOT NULL,
    profile_img character varying(100),
    address character varying(100),
    city character varying(100),
    state character varying(20),
    zip_code character varying(10),
    country character varying(20),
    lat double precision,
    lng double precision,
    status integer NOT NULL,
    documents text[],
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint
);


-- ALTER TABLE o_transportation_provider_profiles OWNER TO postgres;

--
-- TOC entry 310 (class 1259 OID 18859)
-- -- Name: o_trip_events; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE TABLE o_trip_events (
    id bigint NOT NULL,
    trip_id character varying(50) NOT NULL,
    previous_status character varying(50),
    current_status character varying(50) NOT NULL,
    event_type character varying(100) NOT NULL,
    event_timestamp timestamp without time zone DEFAULT now() NOT NULL,
    provider_id integer,
    payload text,
    driver_id bigint NOT NULL
);


-- ALTER TABLE o_trip_events OWNER TO postgres;

--
-- TOC entry 309 (class 1259 OID 18858)
-- -- Name: o_trip_events_id_seq; Type: SEQUENCE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_trip_events_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


-- ALTER SEQUENCE o_trip_events_id_seq OWNER TO postgres;

--
-- TOC entry 5659 (class 0 OID 0)
-- Dependencies: 309
-- -- Name: o_trip_events_id_seq; Type: SEQUENCE OWNED BY; Schema: axcl_dev; Owner: postgres
--

ALTER SEQUENCE o_trip_events_id_seq OWNED BY o_trip_events.id;


--
-- TOC entry 297 (class 1259 OID 18653)
-- -- Name: o_trip_location_history; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_trip_location_history_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_trip_location_history (
    id bigint DEFAULT nextval('o_trip_location_history_id_seq'::regclass) NOT NULL,
    trip_id bigint NOT NULL,
    driver_id bigint NOT NULL,
    location geometry(Point,4326) NOT NULL,
    event_time timestamp without time zone NOT NULL,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint
);


-- ALTER TABLE o_trip_location_history OWNER TO postgres;

--
-- TOC entry 294 (class 1259 OID 18627)
-- -- Name: o_trip_procedures; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE TABLE o_trip_procedures (
    id bigint NOT NULL,
    trip_id bigint NOT NULL,
    code character(5),
    modifier character(2),
    type_id integer,
    cost double precision,
    is_cost_per_unit boolean,
    free_units integer,
    payable_units integer,
    payable_units_cost double precision
);


-- ALTER TABLE o_trip_procedures OWNER TO postgres;

--
-- TOC entry 295 (class 1259 OID 18633)
-- -- Name: o_trips; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_trips_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE o_trips (
    id bigint DEFAULT nextval('o_trips_id_seq'::regclass) NOT NULL,
    trip_id character varying(50) NOT NULL,
    is_copy_of character varying(50),
    date date,
    reason_id integer,
    reason_name character varying(50),
    service_level_code character varying(20),
    vehicle_equipment_codes text[],
    facility_phone character varying(20),
    facility_phone_ext character varying(5),
    ordering_provider_name character varying(100),
    ordering_provider_npi character(10),
    client_id character varying(50),
    insurance_provider_id integer,
    client_first_name character varying(50),
    client_last_name character varying(50),
    client_gender character(1),
    client_birth_date date,
    client_county_code character varying(4),
    is_low_vehicle_required boolean,
    escort_personal_care_attendant_count integer,
    escort_adult_count integer,
    escort_child_count integer,
    escort_child_seat_count integer,
    escort_animal_count integer,
    wc_seat_count integer,
    pickup_name character varying(100),
    pickup_address character varying(100),
    pickup_building character varying(10),
    pickup_apartment character varying(50),
    pickup_city character varying(35),
    pickup_county_code character varying(4),
    pickup_state_code character(2),
    pickup_zip_code character(5),
    pickup_phone character varying(20),
    pickup_phone_ext character varying(5),
    pickup_alternate_phone character varying(20),
    pickup_alternate_phone_ext character varying(5),
    pickup_directions character varying(130),
    pickup_lat double precision,
    pickup_lng double precision,
    drop_off_name character varying(100),
    drop_off_address character varying(100),
    drop_off_building character varying(10),
    drop_off_apartment character varying(50),
    drop_off_city character varying(35),
    drop_off_county_code character varying(4),
    drop_off_state_code character(2),
    drop_off_zip_code character(5),
    drop_off_directions character varying(130),
    drop_off_lat double precision,
    drop_off_lng double precision,
    scheduled_pick_up_timestamp timestamp without time zone,
    scheduled_pick_up_timestamp_source_id integer,
    latest_pick_up_timestamp timestamp without time zone,
    scheduled_drop_off_timestamp timestamp without time zone,
    scheduled_drop_off_timestamp_source_id integer,
    pick_up_arrival_timestamp timestamp without time zone,
    pick_up_timestamp timestamp without time zone,
    drop_off_timestamp timestamp without time zone,
    mileage double precision,
    is_congestion_surcharge_route boolean,
    is_covid_eligible_transport_required boolean,
    last_modified_at timestamp without time zone,
    assignment_type_code character varying(2),
    acceptance_status_id integer,
    is_done_by_not_integrated_provider boolean,
    status_id integer,
    is_confirmed boolean,
    cancel_reason_id integer,
    cancel_note character varying(170),
    notes_from_provider text,
    gross_cost double precision,
    initial_cost double precision,
    procedures_cost double precision,
    pick_up_arrival_cost double precision,
    delivery_cost double precision,
    adjustment double precision,
    adjustment_note text,
    actual_cost double precision,
    fare double precision,
    late_cancel_cost double precision,
    no_show_cost double precision,
    general_incentive_cost double precision,
    toll_cost double precision,
    vehicle_id bigint,
    license_plate_number character varying(20),
    driver_id bigint,
    license_number character varying(20),
    license_state_code character(2),
    billing_status_id integer,
    billing_status_name character varying(50),
    billing_note text,
    payable_amount double precision,
    payable_late_cancel_cost double precision,
    payable_no_show_cost double precision,
    payable_general_incentive_cost double precision,
    payable_toll_cost double precision,
    toll_rejection_reason text,
    toll_rejection_note text,
    comments text,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint,
    transport_provider_id bigint,
    trip_provider bigint,
    last_sentry_sync_successful boolean,
    last_sentry_sync_time timestamp without time zone,
    last_sentry_sync_remarks text
);


-- ALTER TABLE o_trips OWNER TO postgres;

--
-- TOC entry 275 (class 1259 OID 18406)
-- -- Name: o_users; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_users (
    id bigint DEFAULT nextval('o_users_id_seq'::regclass) NOT NULL,
    name character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    mobile_number character varying(15) NOT NULL,
    iso2_country_code character varying(2) NOT NULL,
    password_hash character varying(120) NOT NULL,
    gender integer NOT NULL,
    user_role integer NOT NULL,
    user_status integer NOT NULL,
    last_logout_at timestamp without time zone,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint
);


-- ALTER TABLE o_users OWNER TO postgres;

--
-- TOC entry 281 (class 1259 OID 18485)
-- -- Name: o_vehicles; Type: TABLE; Schema: axcl_dev; Owner: postgres
--

CREATE SEQUENCE o_vehicles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE o_vehicles (
    id bigint DEFAULT nextval('o_vehicles_id_seq'::regclass) NOT NULL,
    transport_provider_id bigint NOT NULL,
    sentry_vehicle_id integer,
    vin character varying(50) NOT NULL,
    fleet_number character varying(50) NOT NULL,
    production_year integer NOT NULL,
    type_id integer NOT NULL,
    make character varying(50) NOT NULL,
    model character varying(50) NOT NULL,
    color character varying(50) NOT NULL,
    seat_number integer NOT NULL,
    status_id integer NOT NULL,
    dmv_license_plate_number character varying(256) NOT NULL,
    dmv_license_plate_category_id integer NOT NULL,
    dmv_state_code character(20) NOT NULL,
    dmv_effective_date date NOT NULL,
    dmv_expiration_date date NOT NULL,
    dmv_document_url text,
    extra_license_number character varying(100),
    extra_type_id integer,
    extra_effective_date date,
    extra_expiration_date date,
    extra_document_url text,
    insurance_policy_number character varying(250) NOT NULL,
    insurance_insurer_name character varying(255) NOT NULL,
    insurance_effective_date date NOT NULL,
    insurance_expiration_date date NOT NULL,
    insurance_document_url text NOT NULL,
    inspection_effective_date date NOT NULL,
    inspection_expiration_date date NOT NULL,
    inspection_document_url text NOT NULL,
    created_on timestamp without time zone NOT NULL,
    updated_on timestamp without time zone,
    deleted_on timestamp without time zone,
    created_by bigint NOT NULL,
    updated_by bigint,
    deleted_by bigint,
    vehicle_type character varying(50) DEFAULT 'Unknown'::character varying NOT NULL,
    CONSTRAINT o_vehicles_extra_type_id_check CHECK ((extra_type_id = ANY (ARRAY[1, 2, 3])))
);


-- ALTER TABLE o_vehicles OWNER TO postgres;

--
-- TOC entry 5318 (class 2604 OID 18862)
-- -- Name: o_trip_events id; Type: DEFAULT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_trip_events ALTER COLUMN id SET DEFAULT nextval('o_trip_events_id_seq'::regclass);



SELECT pg_catalog.setval('o_trip_events_id_seq', 10, true);


--
-- TOC entry 5324 (class 2606 OID 18405)
-- -- Name: databasechangeloglock databasechangeloglock_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY databasechangeloglock
    ADD CONSTRAINT databasechangeloglock_pkey PRIMARY KEY (id);


--
-- TOC entry 5392 (class 2606 OID 18534)
-- -- Name: m_insurance_providers m_insurance_providers_insurance_provider_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_insurance_providers
    ADD CONSTRAINT m_insurance_providers_insurance_provider_id_key UNIQUE (insurance_provider_id);


--
-- TOC entry 5394 (class 2606 OID 18536)
-- -- Name: m_insurance_providers m_insurance_providers_insurance_provider_name_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_insurance_providers
    ADD CONSTRAINT m_insurance_providers_insurance_provider_name_key UNIQUE (insurance_provider_name);


--
-- TOC entry 5396 (class 2606 OID 18532)
-- -- Name: m_insurance_providers m_insurance_providers_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_insurance_providers
    ADD CONSTRAINT m_insurance_providers_pkey PRIMARY KEY (id);


--
-- TOC entry 5428 (class 2606 OID 18594)
-- -- Name: m_service_level_codes m_service_level_codes_code_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_service_level_codes
    ADD CONSTRAINT m_service_level_codes_code_key UNIQUE (code);


--
-- TOC entry 5430 (class 2606 OID 18596)
-- -- Name: m_service_level_codes m_service_level_codes_description_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_service_level_codes
    ADD CONSTRAINT m_service_level_codes_description_key UNIQUE (description);


--
-- TOC entry 5432 (class 2606 OID 18592)
-- -- Name: m_service_level_codes m_service_level_codes_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_service_level_codes
    ADD CONSTRAINT m_service_level_codes_pkey PRIMARY KEY (id);


--
-- TOC entry 5404 (class 2606 OID 18554)
-- -- Name: m_trip_acceptance_statuses m_trip_acceptance_statuses_acceptance_status_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_acceptance_statuses
    ADD CONSTRAINT m_trip_acceptance_statuses_acceptance_status_id_key UNIQUE (acceptance_status_id);


--
-- TOC entry 5406 (class 2606 OID 18556)
-- -- Name: m_trip_acceptance_statuses m_trip_acceptance_statuses_description_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_acceptance_statuses
    ADD CONSTRAINT m_trip_acceptance_statuses_description_key UNIQUE (description);


--
-- TOC entry 5408 (class 2606 OID 18552)
-- -- Name: m_trip_acceptance_statuses m_trip_acceptance_statuses_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_acceptance_statuses
    ADD CONSTRAINT m_trip_acceptance_statuses_pkey PRIMARY KEY (id);


--
-- TOC entry 5398 (class 2606 OID 18544)
-- -- Name: m_trip_assignment_types m_trip_assignment_types_assignment_type_code_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_assignment_types
    ADD CONSTRAINT m_trip_assignment_types_assignment_type_code_key UNIQUE (assignment_type_code);


--
-- TOC entry 5400 (class 2606 OID 18546)
-- -- Name: m_trip_assignment_types m_trip_assignment_types_description_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_assignment_types
    ADD CONSTRAINT m_trip_assignment_types_description_key UNIQUE (description);


--
-- TOC entry 5402 (class 2606 OID 18542)
-- -- Name: m_trip_assignment_types m_trip_assignment_types_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_assignment_types
    ADD CONSTRAINT m_trip_assignment_types_pkey PRIMARY KEY (id);


--
-- TOC entry 5410 (class 2606 OID 18566)
-- -- Name: m_trip_billing_statuses m_trip_billing_statuses_description_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_billing_statuses
    ADD CONSTRAINT m_trip_billing_statuses_description_key UNIQUE (description);


--
-- TOC entry 5412 (class 2606 OID 18562)
-- -- Name: m_trip_billing_statuses m_trip_billing_statuses_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_billing_statuses
    ADD CONSTRAINT m_trip_billing_statuses_pkey PRIMARY KEY (id);


--
-- TOC entry 5414 (class 2606 OID 18564)
-- -- Name: m_trip_billing_statuses m_trip_billing_statuses_status_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_billing_statuses
    ADD CONSTRAINT m_trip_billing_statuses_status_id_key UNIQUE (status_id);


--
-- TOC entry 5440 (class 2606 OID 18612)
-- -- Name: m_trip_cancel_reasons m_trip_cancel_reasons_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_cancel_reasons
    ADD CONSTRAINT m_trip_cancel_reasons_pkey PRIMARY KEY (id);


--
-- TOC entry 5442 (class 2606 OID 18614)
-- -- Name: m_trip_cancel_reasons m_trip_cancel_reasons_reason_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_cancel_reasons
    ADD CONSTRAINT m_trip_cancel_reasons_reason_id_key UNIQUE (reason_id);


--
-- TOC entry 5444 (class 2606 OID 18616)
-- -- Name: m_trip_cancel_reasons m_trip_cancel_reasons_reason_name_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_cancel_reasons
    ADD CONSTRAINT m_trip_cancel_reasons_reason_name_key UNIQUE (reason_name);


--
-- TOC entry 5416 (class 2606 OID 18576)
-- -- Name: m_trip_procedure_types m_trip_procedure_types_description_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_procedure_types
    ADD CONSTRAINT m_trip_procedure_types_description_key UNIQUE (description);


--
-- TOC entry 5418 (class 2606 OID 18572)
-- -- Name: m_trip_procedure_types m_trip_procedure_types_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_procedure_types
    ADD CONSTRAINT m_trip_procedure_types_pkey PRIMARY KEY (id);


--
-- TOC entry 5420 (class 2606 OID 18574)
-- -- Name: m_trip_procedure_types m_trip_procedure_types_type_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_procedure_types
    ADD CONSTRAINT m_trip_procedure_types_type_id_key UNIQUE (type_id);


--
-- TOC entry 5422 (class 2606 OID 18582)
-- -- Name: m_trip_reasons m_trip_reasons_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_reasons
    ADD CONSTRAINT m_trip_reasons_pkey PRIMARY KEY (id);


--
-- TOC entry 5424 (class 2606 OID 18584)
-- -- Name: m_trip_reasons m_trip_reasons_reason_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_reasons
    ADD CONSTRAINT m_trip_reasons_reason_id_key UNIQUE (reason_id);


--
-- TOC entry 5426 (class 2606 OID 18586)
-- -- Name: m_trip_reasons m_trip_reasons_reason_name_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_reasons
    ADD CONSTRAINT m_trip_reasons_reason_name_key UNIQUE (reason_name);


--
-- TOC entry 5458 (class 2606 OID 18652)
-- -- Name: m_trip_statuses m_trip_statuses_description_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_statuses
    ADD CONSTRAINT m_trip_statuses_description_key UNIQUE (description);


--
-- TOC entry 5460 (class 2606 OID 18648)
-- -- Name: m_trip_statuses m_trip_statuses_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_statuses
    ADD CONSTRAINT m_trip_statuses_pkey PRIMARY KEY (id);


--
-- TOC entry 5462 (class 2606 OID 18650)
-- -- Name: m_trip_statuses m_trip_statuses_status_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_statuses
    ADD CONSTRAINT m_trip_statuses_status_id_key UNIQUE (status_id);


--
-- TOC entry 5446 (class 2606 OID 18626)
-- -- Name: m_trip_timestamp_sources m_trip_timestamp_sources_description_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_timestamp_sources
    ADD CONSTRAINT m_trip_timestamp_sources_description_key UNIQUE (description);


--
-- TOC entry 5448 (class 2606 OID 18622)
-- -- Name: m_trip_timestamp_sources m_trip_timestamp_sources_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_timestamp_sources
    ADD CONSTRAINT m_trip_timestamp_sources_pkey PRIMARY KEY (id);


--
-- TOC entry 5450 (class 2606 OID 18624)
-- -- Name: m_trip_timestamp_sources m_trip_timestamp_sources_timestamp_source_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_trip_timestamp_sources
    ADD CONSTRAINT m_trip_timestamp_sources_timestamp_source_id_key UNIQUE (timestamp_source_id);


--
-- TOC entry 5434 (class 2606 OID 18604)
-- -- Name: m_vehicle_equipment_codes m_vehicle_equipment_codes_code_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_vehicle_equipment_codes
    ADD CONSTRAINT m_vehicle_equipment_codes_code_key UNIQUE (code);


--
-- TOC entry 5436 (class 2606 OID 18606)
-- -- Name: m_vehicle_equipment_codes m_vehicle_equipment_codes_description_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_vehicle_equipment_codes
    ADD CONSTRAINT m_vehicle_equipment_codes_description_key UNIQUE (description);


--
-- TOC entry 5438 (class 2606 OID 18602)
-- -- Name: m_vehicle_equipment_codes m_vehicle_equipment_codes_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY m_vehicle_equipment_codes
    ADD CONSTRAINT m_vehicle_equipment_codes_pkey PRIMARY KEY (id);


--
-- TOC entry 5360 (class 2606 OID 18471)
-- -- Name: o_auth_tokens o_auth_tokens_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_auth_tokens
    ADD CONSTRAINT o_auth_tokens_pkey PRIMARY KEY (id);


--
-- TOC entry 5362 (class 2606 OID 18473)
-- -- Name: o_auth_tokens o_auth_tokens_user_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_auth_tokens
    ADD CONSTRAINT o_auth_tokens_user_id_key UNIQUE (user_id);


--
-- TOC entry 5470 (class 2606 OID 18673)
-- -- Name: o_driver_location o_driver_location_driver_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_driver_location
    ADD CONSTRAINT o_driver_location_driver_id_key UNIQUE (driver_id);


--
-- TOC entry 5473 (class 2606 OID 18671)
-- -- Name: o_driver_location o_driver_location_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_driver_location
    ADD CONSTRAINT o_driver_location_pkey PRIMARY KEY (id);


--
-- TOC entry 5344 (class 2606 OID 18445)
-- -- Name: o_driver_profiles o_driver_profiles_dmv_license_number_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_driver_profiles
    ADD CONSTRAINT o_driver_profiles_dmv_license_number_key UNIQUE (dmv_license_number);


--
-- TOC entry 5346 (class 2606 OID 18443)
-- -- Name: o_driver_profiles o_driver_profiles_phone_number_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_driver_profiles
    ADD CONSTRAINT o_driver_profiles_phone_number_key UNIQUE (phone_number);


--
-- TOC entry 5348 (class 2606 OID 18441)
-- -- Name: o_driver_profiles o_driver_profiles_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_driver_profiles
    ADD CONSTRAINT o_driver_profiles_pkey PRIMARY KEY (id);


--
-- TOC entry 5388 (class 2606 OID 18523)
-- -- Name: o_driver_shifts o_driver_shifts_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_driver_shifts
    ADD CONSTRAINT o_driver_shifts_pkey PRIMARY KEY (id);


--
-- TOC entry 5384 (class 2606 OID 18512)
-- -- Name: o_driver_transport_provider_assignments o_driver_transport_provider_assignments_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_driver_transport_provider_assignments
    ADD CONSTRAINT o_driver_transport_provider_assignments_pkey PRIMARY KEY (id);


--
-- TOC entry 5355 (class 2606 OID 18460)
-- -- Name: o_extra_commercial_licenses o_extra_commercial_licenses_license_number_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_extra_commercial_licenses
    ADD CONSTRAINT o_extra_commercial_licenses_license_number_key UNIQUE (license_number);


--
-- TOC entry 5357 (class 2606 OID 18458)
-- -- Name: o_extra_commercial_licenses o_extra_commercial_licenses_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_extra_commercial_licenses
    ADD CONSTRAINT o_extra_commercial_licenses_pkey PRIMARY KEY (id);


--
-- TOC entry 5364 (class 2606 OID 18481)
-- -- Name: o_file_uploads_metadata o_file_uploads_metadata_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_file_uploads_metadata
    ADD CONSTRAINT o_file_uploads_metadata_pkey PRIMARY KEY (id);


--
-- TOC entry 5335 (class 2606 OID 18428)
-- -- Name: o_transportation_provider_profiles o_transportation_provider_profiles_company_name_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_transportation_provider_profiles
    ADD CONSTRAINT o_transportation_provider_profiles_company_name_key UNIQUE (company_name);


--
-- TOC entry 5337 (class 2606 OID 18430)
-- -- Name: o_transportation_provider_profiles o_transportation_provider_profiles_lic_number_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_transportation_provider_profiles
    ADD CONSTRAINT o_transportation_provider_profiles_lic_number_key UNIQUE (lic_number);


--
-- TOC entry 5339 (class 2606 OID 18426)
-- -- Name: o_transportation_provider_profiles o_transportation_provider_profiles_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_transportation_provider_profiles
    ADD CONSTRAINT o_transportation_provider_profiles_pkey PRIMARY KEY (id);


--
-- TOC entry 5475 (class 2606 OID 18867)
-- -- Name: o_trip_events o_trip_events_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_trip_events
    ADD CONSTRAINT o_trip_events_pkey PRIMARY KEY (id);


--
-- TOC entry 5466 (class 2606 OID 18660)
-- -- Name: o_trip_location_history o_trip_location_history_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_trip_location_history
    ADD CONSTRAINT o_trip_location_history_pkey PRIMARY KEY (id);


--
-- TOC entry 5452 (class 2606 OID 18632)
-- -- Name: o_trip_procedures o_trip_procedures_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_trip_procedures
    ADD CONSTRAINT o_trip_procedures_pkey PRIMARY KEY (id);


--
-- TOC entry 5454 (class 2606 OID 18640)
-- -- Name: o_trips o_trips_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_trips
    ADD CONSTRAINT o_trips_pkey PRIMARY KEY (id);


--
-- TOC entry 5456 (class 2606 OID 18642)
-- -- Name: o_trips o_trips_trip_id_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_trips
    ADD CONSTRAINT o_trips_trip_id_key UNIQUE (trip_id);


--
-- TOC entry 5326 (class 2606 OID 18413)
-- -- Name: o_users o_users_email_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_users
    ADD CONSTRAINT o_users_email_key UNIQUE (email);


--
-- TOC entry 5328 (class 2606 OID 18415)
-- -- Name: o_users o_users_mobile_number_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_users
    ADD CONSTRAINT o_users_mobile_number_key UNIQUE (mobile_number);


--
-- TOC entry 5330 (class 2606 OID 18411)
-- -- Name: o_users o_users_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_users
    ADD CONSTRAINT o_users_pkey PRIMARY KEY (id);


--
-- TOC entry 5370 (class 2606 OID 18497)
-- -- Name: o_vehicles o_vehicles_dmv_license_plate_number_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_vehicles
    ADD CONSTRAINT o_vehicles_dmv_license_plate_number_key UNIQUE (dmv_license_plate_number);


--
-- TOC entry 5375 (class 2606 OID 18493)
-- -- Name: o_vehicles o_vehicles_pkey; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_vehicles
    ADD CONSTRAINT o_vehicles_pkey PRIMARY KEY (id);


--
-- TOC entry 5380 (class 2606 OID 18495)
-- -- Name: o_vehicles o_vehicles_vin_key; Type: CONSTRAINT; Schema: axcl_dev; Owner: postgres
--

ALTER TABLE ONLY o_vehicles
    ADD CONSTRAINT o_vehicles_vin_key UNIQUE (vin);


--
-- TOC entry 5385 (class 1259 OID 18683)
-- -- Name: idx_driver_shifts_active; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX idx_driver_shifts_active ON o_driver_shifts USING btree (driver_id, shift_start_time, shift_end_time, is_active);


--
-- TOC entry 5468 (class 1259 OID 18675)
-- -- Name: o_driver_location_driver_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_location_driver_id_idx ON o_driver_location USING btree (driver_id);


--
-- TOC entry 5471 (class 1259 OID 18674)
-- -- Name: o_driver_location_location_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_location_location_idx ON o_driver_location USING gist (location);


--
-- TOC entry 5341 (class 1259 OID 18450)
-- -- Name: o_driver_profiles_bg_expiration_date_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_profiles_bg_expiration_date_idx ON o_driver_profiles USING btree (bg_expiration_date);


--
-- TOC entry 5342 (class 1259 OID 18449)
-- -- Name: o_driver_profiles_dmv_expiration_date_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_profiles_dmv_expiration_date_idx ON o_driver_profiles USING btree (dmv_expiration_date);


--
-- TOC entry 5349 (class 1259 OID 18446)
-- -- Name: o_driver_profiles_sentry_driver_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_profiles_sentry_driver_id_idx ON o_driver_profiles USING btree (sentry_driver_id);


--
-- TOC entry 5350 (class 1259 OID 18447)
-- -- Name: o_driver_profiles_user_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_profiles_user_id_idx ON o_driver_profiles USING btree (user_id);


--
-- TOC entry 5351 (class 1259 OID 18448)
-- -- Name: o_driver_profiles_user_status_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_profiles_user_status_idx ON o_driver_profiles USING btree (user_status);


--
-- TOC entry 5386 (class 1259 OID 18524)
-- -- Name: o_driver_shifts_driver_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_shifts_driver_id_idx ON o_driver_shifts USING btree (driver_id);


--
-- TOC entry 5389 (class 1259 OID 18525)
-- -- Name: o_driver_shifts_transport_provider_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_shifts_transport_provider_id_idx ON o_driver_shifts USING btree (transport_provider_id);


--
-- TOC entry 5390 (class 1259 OID 18526)
-- -- Name: o_driver_shifts_vehicle_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_shifts_vehicle_id_idx ON o_driver_shifts USING btree (vehicle_id);


--
-- TOC entry 5381 (class 1259 OID 18514)
-- -- Name: o_driver_transport_provider_assignmen_transport_provider_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_transport_provider_assignmen_transport_provider_id_idx ON o_driver_transport_provider_assignments USING btree (transport_provider_id);


--
-- TOC entry 5382 (class 1259 OID 18513)
-- -- Name: o_driver_transport_provider_assignments_driver_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_driver_transport_provider_assignments_driver_id_idx ON o_driver_transport_provider_assignments USING btree (driver_id);


--
-- TOC entry 5352 (class 1259 OID 18461)
-- -- Name: o_extra_commercial_licenses_driver_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_extra_commercial_licenses_driver_id_idx ON o_extra_commercial_licenses USING btree (driver_id);


--
-- TOC entry 5353 (class 1259 OID 18462)
-- -- Name: o_extra_commercial_licenses_expiration_date_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_extra_commercial_licenses_expiration_date_idx ON o_extra_commercial_licenses USING btree (expiration_date);


--
-- TOC entry 5358 (class 1259 OID 18463)
-- -- Name: o_extra_commercial_licenses_type_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_extra_commercial_licenses_type_id_idx ON o_extra_commercial_licenses USING btree (type_id);


--
-- TOC entry 5365 (class 1259 OID 18482)
-- -- Name: o_file_uploads_metadata_status_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_file_uploads_metadata_status_idx ON o_file_uploads_metadata USING btree (status);


--
-- TOC entry 5366 (class 1259 OID 18484)
-- -- Name: o_file_uploads_metadata_status_upload_type_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_file_uploads_metadata_status_upload_type_idx ON o_file_uploads_metadata USING btree (status, upload_type);


--
-- TOC entry 5367 (class 1259 OID 18483)
-- -- Name: o_file_uploads_metadata_upload_type_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_file_uploads_metadata_upload_type_idx ON o_file_uploads_metadata USING btree (upload_type);


--
-- TOC entry 5340 (class 1259 OID 18431)
-- -- Name: o_transportation_provider_profiles_status_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_transportation_provider_profiles_status_idx ON o_transportation_provider_profiles USING btree (status);


--
-- TOC entry 5463 (class 1259 OID 18663)
-- -- Name: o_trip_location_history_driver_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_trip_location_history_driver_id_idx ON o_trip_location_history USING btree (driver_id);


--
-- TOC entry 5464 (class 1259 OID 18661)
-- -- Name: o_trip_location_history_location_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_trip_location_history_location_idx ON o_trip_location_history USING gist (location);


--
-- TOC entry 5467 (class 1259 OID 18662)
-- -- Name: o_trip_location_history_trip_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_trip_location_history_trip_id_idx ON o_trip_location_history USING btree (trip_id);


--
-- TOC entry 5331 (class 1259 OID 18416)
-- -- Name: o_users_user_role_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_users_user_role_idx ON o_users USING btree (user_role);


--
-- TOC entry 5332 (class 1259 OID 18418)
-- -- Name: o_users_user_role_user_status_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_users_user_role_user_status_idx ON o_users USING btree (user_role, user_status);


--
-- TOC entry 5333 (class 1259 OID 18417)
-- -- Name: o_users_user_status_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_users_user_status_idx ON o_users USING btree (user_status);


--
-- TOC entry 5368 (class 1259 OID 18501)
-- -- Name: o_vehicles_dmv_expiration_date_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_vehicles_dmv_expiration_date_idx ON o_vehicles USING btree (dmv_expiration_date);


--
-- TOC entry 5371 (class 1259 OID 18502)
-- -- Name: o_vehicles_extra_expiration_date_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_vehicles_extra_expiration_date_idx ON o_vehicles USING btree (extra_expiration_date);


--
-- TOC entry 5372 (class 1259 OID 18504)
-- -- Name: o_vehicles_inspection_expiration_date_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_vehicles_inspection_expiration_date_idx ON o_vehicles USING btree (inspection_expiration_date);


--
-- TOC entry 5373 (class 1259 OID 18503)
-- -- Name: o_vehicles_insurance_expiration_date_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_vehicles_insurance_expiration_date_idx ON o_vehicles USING btree (insurance_expiration_date);


--
-- TOC entry 5376 (class 1259 OID 18498)
-- -- Name: o_vehicles_sentry_vehicle_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_vehicles_sentry_vehicle_id_idx ON o_vehicles USING btree (sentry_vehicle_id);


--
-- TOC entry 5377 (class 1259 OID 18500)
-- -- Name: o_vehicles_status_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_vehicles_status_id_idx ON o_vehicles USING btree (status_id);


--
-- TOC entry 5378 (class 1259 OID 18499)
-- -- Name: o_vehicles_transport_provider_id_idx; Type: INDEX; Schema: axcl_dev; Owner: postgres
--

CREATE INDEX o_vehicles_transport_provider_id_idx ON o_vehicles USING btree (transport_provider_id);


-- Completed on 2025-09-29 19:07:12 EDT

--
-- -- PostgreSQL database dump complete
--

